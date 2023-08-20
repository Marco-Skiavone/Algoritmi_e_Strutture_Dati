package src;
import java.util.*;

public class Graph<V, L> implements AbstractGraph<V, L> {
	private boolean directed;		/* orientato */
	private boolean labelled;
	private HashMap<V, ArrayList<Edge<V, L>>> map; /** V is the code of the start of the edges */

	public Graph(boolean directed, boolean labelled){
		this.directed = directed;
		this.labelled = labelled;
		map = new HashMap<V, ArrayList<Edge<V, L>>>();
	}

	@Override
	public boolean isDirected() {			// DONE
		return directed;
	}

	@Override
	public boolean isLabelled() {			// DONE
		return labelled;
	}

	@Override
	public boolean addNode(V a) {			// DONE
		if(a != null && !containsNode(a)) {
			map.put(a, new ArrayList<Edge<V, L>>());
			return true;
		}
		return false;
	}

	@Override
	public boolean addEdge(V a, V b, L l) {						// DONE
		if(labelled && l == null)
			return false;
		if(!containsNode(a) || !containsNode(b)) // check anche se sono null
			return false;
		if(directed){
			if(!containsEdge(a, b))
				return map.get(a).add(new Edge<V,L>(a, b, l));
		} else {
			if(!containsEdge(a, b)){
				return map.get(a).add(new Edge<V, L>(a, b, l)) && map.get(b).add(new Edge<V, L>(b, a, l));
			} 
		}
		return false;
	}

	@Override
	public boolean containsNode(V a) {				// DONE
		if(map.isEmpty() || a == null)
			return false;
		return map.containsKey(a);
	}

	@Override
	public boolean containsEdge(V a, V b) {				// DONE
		if(map.isEmpty())
			return false;
		if(a == null || b == null)
			return false;
		if(!directed){
			return (map.containsKey(a) && map.get(a).contains(new Edge<V,L>(a, b, null))) && 
				(map.containsKey(b) && map.get(b).contains(new Edge<V,L>(b, a, null)));
		} else {
			return (map.containsKey(a) && map.containsKey(b) && map.get(a).contains(new Edge<V,L>(a, b, null)));
		}
	}

	@Override
	public boolean removeNode(V a) {				// DONE
		if(!containsNode(a))
			return false;
		if(directed){
			if(map.remove(a) == null)
				return false;
			for(ArrayList<Edge<V, L>> arr : map.values()){
				arr.removeIf(el -> el.getEnd().equals(a));
			}
			return true;
		} else {
			for(Edge<V,L> ed : map.get(a)){
				if(!map.get(ed.getEnd()).removeIf(el -> el.getEnd().equals(a)))
					throw new GraphException("Failed removeIf on removeNode().");
			}
			return map.remove(a) != null;
		}
	}

	@Override
	public boolean removeEdge(V a, V b) {				// DONE
		if(!containsEdge(a, b))
			return false;
		if(directed)
			return map.get(a).removeIf(ed -> ed.getStart().equals(a) && ed.getEnd().equals(b));
		else 
			return map.get(a).removeIf(ed -> ed.getStart().equals(a) && ed.getEnd().equals(b)) && 
				map.get(b).removeIf(ed -> ed.getStart().equals(b) && ed.getEnd().equals(a));
	}

	@Override
	public int numNodes() {			// DONE
		return map.size();
	}

	@Override
	public int numEdges() {			// DONE
		int ret = 0;
		if(!map.isEmpty()){
			for(V v : map.keySet())
				ret += map.get(v).size();
		}
		return directed? ret : ret % 2 == 0 ? ret/2 : ret;
	}

	@Override
	public Collection<V> getNodes() {		// DONE
		return new ArrayList<V>(map.keySet());
	}

	@Override
	public Collection<? extends AbstractEdge<V, L>> getEdges() {		// DONE
		if(map.isEmpty())
			return null;
		ArrayList<Edge<V, L>> ret = new ArrayList<>();
		for (ArrayList<Edge<V, L>> ar : map.values()) 
			ret.addAll(ar);
		return ret;
	}

	@Override
	public Collection<V> getNeighbours(V a) {	// DONE
		if(map.isEmpty() || !containsNode(a))
			return null;
		ArrayList<V> ret = new ArrayList<>();
		for(Edge<V, L> ed : map.get(a))
			if(ed.getStart().equals(a))
				ret.add(ed.getEnd());
		return ret;	
	}

	/*** @return {@value null} - When the graph has not been initialized as labeled. */
	@Override
	public L getLabel(V a, V b) {		// 	DONE
		if(labelled){
			if(containsEdge(a, b)){
				for(Edge<V, L> ed : map.get(a))
					if(ed.getEnd().equals(b))
						return ed.getLabel();
			} else 
				throw new GraphException("Invoked getLabel() on not existing edge.");
		}
		return null;
	}	
}