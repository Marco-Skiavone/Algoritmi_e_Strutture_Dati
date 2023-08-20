package src;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Prim {

	public static <V, L extends Number> Collection<? extends AbstractEdge<V, L>> minimumSpanningForest(Graph<V, L> graph){
		if(graph == null || graph.numNodes() <= 0 || graph.numEdges() <= 0)
			return null;
		Collection<AbstractEdge<V, L>> a = new ArrayList<>();
		PriorityQueue<AbstractEdge<V, L>> q = new PriorityQueue<>((x, y) -> {return Double.compare(x.getLabel().doubleValue(), y.getLabel().doubleValue());});
		HashSet<V> visitedNodes = new HashSet<>();		// black nodes
		while(visitedNodes.size() < graph.numNodes()){
			V r = null;
			for(V v : graph.getNodes())
				if(!visitedNodes.contains(v)){
					r = v;	// found first unvisited neighbour
					break;
				}
			visitedNodes.add(r);

			for (V ngb : graph.getNeighbours(r)) {
				AbstractEdge<V, L> edge = new Edge<>(r, ngb, graph.getLabel(r, ngb));
				q.push(edge);
			}

			while(!q.empty()){
				AbstractEdge<V, L> u = q.top();		// end is the node to visit 
				q.pop();

				if(!visitedNodes.contains(u.getEnd())){
					visitedNodes.add(u.getEnd());
					a.add(u);
					for(V nbg : graph.getNeighbours(u.getEnd()))
						if(!visitedNodes.contains(nbg)){
							AbstractEdge<V, L> edge = new Edge<>(u.getEnd(), nbg, graph.getLabel(u.getEnd(), nbg));
              				q.push(edge);
						}
				}
			}		// end of while -> got all the tree in r.
		}
		return a;
	}

	public static void main(String[] args) {
		if(args[0] == null){
			throw new GraphException("ERROR! in arguments of the main call.");
		}
		String[] s = {"", "", ""};
		Graph<String, Double> g = new Graph<>(false, true);
		try {
			File input = new File(args[0]);
			Scanner scan = new Scanner(input);
			while(scan.hasNext()){
				s = scan.nextLine().split(",");
				if(!g.containsNode(s[0]))
					g.addNode(s[0]);
				if(!g.containsNode(s[1]))
					g.addNode(s[1]);
				double f = Double.parseDouble(s[2]);
				g.addEdge(s[0], s[1], f);
			}
			scan.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
			return;
		}

		Collection<AbstractEdge<String, Double>> minSpanForest = null;
		try {
			minSpanForest = (Collection<AbstractEdge<String, Double>>)Prim.<String, Double>minimumSpanningForest(g);
			if(minSpanForest == null)
				throw new GraphException("Failed Prim.minimumSpanningForest() in Prim.main(String[] argv)!");
		} catch(ClassCastException cce){
			System.err.println(cce.getMessage());
			cce.printStackTrace(System.err);
			return;
		}

		double totalWeight = 0;
		for(AbstractEdge<String, Double> ed : minSpanForest){
			System.out.println(ed.getStart() + ", " + ed.getEnd() + ", " + ed.getLabel());
			totalWeight += ed.getLabel();
		}

		System.err.println("\n-------------------\n");
		System.err.println("Numero di nodi di g: " + g.numNodes());
		System.err.println("Numero di archi di g: " + g.numEdges());
		System.err.println("Numero di archi di minimumSpanningForest: " + minSpanForest.size());
		DecimalFormat fd = new DecimalFormat(".###");	
		System.err.println("Peso totale della foresta ricoprente: " + fd.format((totalWeight / 1000)) + " km."); // distanza (peso) espressa in metri

		// Stampa aggiuntiva
		HashSet<String> nodiForesta = new HashSet<>();
		for(AbstractEdge<String, Double> ed : minSpanForest){
			if(!nodiForesta.contains(ed.getStart()))
				nodiForesta.add(ed.getStart());
			if(!nodiForesta.contains(ed.getEnd()))
				nodiForesta.add(ed.getEnd());
		}
		System.err.println("n nodi finali (effettivi): " + nodiForesta.size());

	}
}
