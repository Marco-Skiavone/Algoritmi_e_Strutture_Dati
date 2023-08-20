package src.unit_test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import src.Edge;
import src.Graph;

public class MyUnitTest4 {

	@Test
	public void testBase1(){
		Graph<String, Float> g = new Graph<>(false, false);
		assertFalse(g.isDirected());
		assertFalse(g.isLabelled());
		Graph<String, Float> g2 = new Graph<>(true, true);
		assertTrue(g2.isDirected());
		assertTrue(g2.isLabelled());
	}

	@Test
	public void testAddNode1(){
		Graph<String, Float> g = new Graph<>(true, false);
		assertTrue(g.isDirected());
		assertTrue(!g.isLabelled());
		assertTrue(g.addNode("ascoli"));
		assertTrue(g.containsNode("ascoli"));
	}

	@Test
	public void testAddNode2directed(){
		Graph<String, Float> g = new Graph<>(true, false);
		assertTrue(g.isDirected());
		assertTrue(!g.isLabelled());
		assertTrue(g.addNode("ascoli piceno"));
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("teramo"));
		assertTrue(g.containsNode("roma"));
		assertTrue(g.containsNode("ascoli piceno"));
		assertTrue(g.containsNode("ancona"));
		assertTrue(g.containsNode("teramo"));
	}

	@Test
	public void testAddNode2labelled(){
		Graph<String, Float> g = new Graph<>(false, true);
		assertTrue(!g.isDirected());
		assertTrue(g.isLabelled());
		assertTrue(g.addNode("ascoli piceno"));
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("teramo"));
		assertTrue(g.containsNode("roma"));
		assertTrue(g.containsNode("ascoli piceno"));
		assertTrue(g.containsNode("ancona"));
		assertTrue(g.containsNode("teramo"));
	}

	@Test
	public void testAddNode2both(){
		Graph<String, Float> g = new Graph<>(true, true);
		assertTrue(g.isDirected());
		assertTrue(g.isLabelled());
		assertTrue(g.addNode("ascoli piceno"));
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("teramo"));
		assertTrue(g.containsNode("roma"));
		assertTrue(g.containsNode("ascoli piceno"));
		assertTrue(g.containsNode("ancona"));
		assertTrue(g.containsNode("teramo"));
	}

	@Test
	public void testContains1(){
		Graph<String, Float> g = new Graph<>(true, false);
		assertTrue(g.isDirected());
		assertTrue(!g.isLabelled());
		assertFalse(g.containsNode("ascoli"));
		assertFalse(g.containsNode("piceno"));
	}

	@Test
	public void testContains2(){
		Graph<String, Float> g = new Graph<>(true, false);
		assertTrue(g.isDirected());
		assertTrue(!g.isLabelled());
		assertTrue(g.addNode("ascoli piceno"));
		assertTrue(g.containsNode("ascoli piceno"));
		assertFalse(g.containsNode("Ascoli piceno"));
	}

	@Test
	public void testAddEdgeDir1(){
		Graph<String, Float> g = new Graph<>(true, false);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertFalse(g.addEdge("roma", "ancona", null));
		assertTrue(g.addEdge("roma", "roma", null));
		assertTrue(g.addEdge("ancona", "roma", null));
		assertTrue(g.numNodes() == 2);
	}

	@Test
	public void testAddEdgeDir2(){
		Graph<String, Float> g = new Graph<>(true, false);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertFalse(g.addEdge("Roma", "ancona", null));
		assertFalse(g.addEdge("roma", "ancona", null));
	}
	
	@Test
	public void testAddEdgeLab1(){
		Graph<String, Float> g = new Graph<>(false, true);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertFalse(g.addEdge("Roma", "ancona", null));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.containsEdge("ancona", "roma"));
		assertTrue(g.containsEdge("roma", "ancona"));
		assertFalse(g.addEdge("roma", "ancona", null));
		assertFalse(g.addEdge("ancona", "roma", 70.3f));
	}

	@Test
	public void testAddEdgeBoth1(){
		Graph<String, Float> g = new Graph<>(true, true);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertFalse(g.addEdge("roma", "ancona", null));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.containsEdge("roma", "ancona"));
		assertTrue(g.addEdge("ancona", "roma", 60.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.containsEdge("ancona", "roma"));
		assertFalse(g.containsEdge("roma", "firenze"));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.containsEdge("roma", "firenze"));
		assertFalse(g.containsEdge("firenze", "roma"));
		assertFalse(g.addEdge("roma", "torino", null));
		assertFalse(g.addEdge("roma", "chieri", 102.4f));
		assertFalse(g.addEdge("terni", "ancona", null));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.numNodes() == 4);
		assertTrue(g.numEdges() == 5);
	}

	@Test
	public void testGetNodes(){
		Graph<String, Float> g = new Graph<>(true, true);
		ArrayList<String> checker = new ArrayList<>();
		checker.add("roma");checker.add("ancona");checker.add("firenze");checker.add("terni");
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("ancona", "roma", 60.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.numNodes() == 4);
		assertTrue(g.numEdges() == 5);
		assertTrue(g.getNodes().containsAll(checker));
	}

	@Test
	public void testGetEdges(){
		Graph<String, Float> g = new Graph<>(true, true);
		ArrayList<Edge<String, Float>> checker = new ArrayList<>();
		Edge<String, Float> e1 = new Edge<>("roma", "ancona", 72.3f);
		Edge<String, Float> e2 = new Edge<>("ancona", "roma", 60.3f);
		Edge<String, Float> e3 = new Edge<>("roma", "terni", 50.3f);
		Edge<String, Float> e4 = new Edge<>("roma", "firenze", 6.3f);
		Edge<String, Float> e5 = new Edge<>("terni", "ancona", 11.1f);
		checker.add(e1);checker.add(e2);checker.add(e3);checker.add(e4);checker.add(e5);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("ancona", "roma", 60.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.numNodes() == 4);
		assertTrue(g.numEdges() == 5);
		assertTrue(g.getEdges().containsAll(checker));
	}

	@Test
	public void testRemove1(){
		Graph<String, Float> g = new Graph<>(true, true);
		ArrayList<String> checkerN = new ArrayList<>();
		checkerN.add("roma");checkerN.add("ancona");checkerN.add("firenze");checkerN.add("terni");
		ArrayList<Edge<String, Float>> checker = new ArrayList<>();
		Edge<String, Float> e1 = new Edge<>("roma", "ancona", 72.3f);
		Edge<String, Float> e2 = new Edge<>("ancona", "roma", 60.3f);
		Edge<String, Float> e3 = new Edge<>("roma", "terni", 50.3f);
		Edge<String, Float> e4 = new Edge<>("roma", "firenze", 6.3f);
		Edge<String, Float> e5 = new Edge<>("terni", "ancona", 11.1f);
		checker.add(e1);checker.add(e2);checker.add(e3);checker.add(e4);checker.add(e5);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("ancona", "roma", 60.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.removeNode("terni"));
		assertTrue(g.numEdges() == 3);
		assertTrue(g.numNodes() == 3);
		assertTrue(!g.getNodes().containsAll(checkerN));
		assertTrue(!g.getEdges().containsAll(checker));
	}

	@Test
	public void testRemove2(){
		Graph<String, Float> g = new Graph<>(false, true);
		ArrayList<String> checkerN = new ArrayList<>();
		checkerN.add("roma");checkerN.add("ancona");checkerN.add("firenze");checkerN.add("terni");
		ArrayList<Edge<String, Float>> checker = new ArrayList<>();
		Edge<String, Float> e1 = new Edge<>("roma", "ancona", 72.3f);
		Edge<String, Float> e2 = new Edge<>("ancona", "roma", 60.3f);
		Edge<String, Float> e3 = new Edge<>("roma", "terni", 50.3f);
		Edge<String, Float> e4 = new Edge<>("roma", "firenze", 6.3f);
		Edge<String, Float> e5 = new Edge<>("terni", "ancona", 11.1f);
		checker.add(e1);checker.add(e2);checker.add(e3);checker.add(e4);checker.add(e5);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.addEdge("terni", "firenze", 11.1f));
		assertTrue(g.addEdge("ancona", "firenze", 11.1f));
		assertTrue(g.numEdges() == 6);
		assertTrue(g.removeNode("terni"));
		assertTrue(g.numEdges() == 3);
		assertTrue(g.numNodes() == 3);
		assertTrue(!g.getNodes().containsAll(checkerN));
		assertTrue(!g.getEdges().containsAll(checker));
	}

	@Test
	public void testRemoveEdge1(){
		Graph<String, Float> g = new Graph<>(false, true);
		ArrayList<String> checkerN = new ArrayList<>();
		checkerN.add("roma");checkerN.add("ancona");checkerN.add("firenze");checkerN.add("terni");
		ArrayList<Edge<String, Float>> checker = new ArrayList<>();
		Edge<String, Float> e1 = new Edge<>("roma", "ancona", 72.3f);
		Edge<String, Float> e2 = new Edge<>("ancona", "roma", 60.3f);
		Edge<String, Float> e3 = new Edge<>("roma", "terni", 50.3f);
		Edge<String, Float> e4 = new Edge<>("roma", "firenze", 6.3f);
		Edge<String, Float> e5 = new Edge<>("terni", "ancona", 11.1f);
		Edge<String, Float> e6 = new Edge<>("terni", "firenze", 11.1f);
		Edge<String, Float> e7 = new Edge<>("firenze", "terni", 31.1f);
		checker.add(e1);checker.add(e2);checker.add(e3);checker.add(e4);checker.add(e5);checker.add(e6);checker.add(e7);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.addEdge("terni", "firenze", 11.1f));
		assertTrue(g.addEdge("ancona", "firenze", 11.1f));
		assertTrue(g.numEdges() == 6);
		assertTrue(g.removeEdge("terni", "firenze"));
		//System.out.println(g.getEdges());
		assertTrue(g.numEdges() == 5);
		assertTrue(g.numNodes() == 4);
		assertTrue(g.getNodes().containsAll(checkerN));
		assertTrue(!g.getEdges().contains(e6));
		assertTrue(!g.getEdges().contains(e7));
	}

	@Test
	public void testRemoveEdge2(){
		Graph<String, Float> g = new Graph<>(true, true);
		ArrayList<String> checkerN = new ArrayList<>();
		checkerN.add("roma");checkerN.add("ancona");checkerN.add("firenze");checkerN.add("terni");
		ArrayList<Edge<String, Float>> checker = new ArrayList<>();
		Edge<String, Float> e1 = new Edge<>("roma", "ancona", 72.3f);
		Edge<String, Float> e2 = new Edge<>("ancona", "roma", 60.3f);
		Edge<String, Float> e3 = new Edge<>("roma", "terni", 50.3f);
		Edge<String, Float> e4 = new Edge<>("roma", "firenze", 6.3f);
		Edge<String, Float> e5 = new Edge<>("terni", "ancona", 11.1f);
		Edge<String, Float> e6 = new Edge<>("terni", "firenze", 11.1f);
		Edge<String, Float> e7 = new Edge<>("firenze", "terni", 31.1f);
		checker.add(e1);checker.add(e2);checker.add(e3);checker.add(e4);checker.add(e5);checker.add(e6);checker.add(e7);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("firenze", "roma", 6.4f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.addEdge("terni", "firenze", 11.3f));
		assertTrue(g.addEdge("firenze", "terni", 6.4f));
		assertTrue(g.addEdge("ancona", "firenze", 11.1f));
		assertTrue(g.numEdges() == 8);
		assertTrue(g.removeEdge("terni", "firenze"));
		assertTrue(g.numEdges() ==7);
		assertTrue(g.numNodes() == 4);
		assertTrue(g.getNodes().containsAll(checkerN));
		assertTrue(!g.getEdges().contains(e6));
		assertTrue(g.getEdges().contains(e7));
	}

	@Test
	public void testGetLabel1(){
		Graph<String, Float> g = new Graph<>(true, true);
		ArrayList<String> checkerN = new ArrayList<>();
		checkerN.add("roma");checkerN.add("ancona");checkerN.add("firenze");checkerN.add("terni");
		ArrayList<Edge<String, Float>> checker = new ArrayList<>();
		Edge<String, Float> e1 = new Edge<>("roma", "ancona", 72.3f);
		Edge<String, Float> e2 = new Edge<>("ancona", "roma", 60.3f);
		Edge<String, Float> e3 = new Edge<>("roma", "terni", 50.3f);
		Edge<String, Float> e4 = new Edge<>("roma", "firenze", 6.3f);
		Edge<String, Float> e5 = new Edge<>("terni", "ancona", 11.1f);
		Edge<String, Float> e6 = new Edge<>("terni", "firenze", 11.1f);
		Edge<String, Float> e7 = new Edge<>("firenze", "terni", 31.1f);
		checker.add(e1);checker.add(e2);checker.add(e3);checker.add(e4);checker.add(e5);checker.add(e6);checker.add(e7);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("firenze", "roma", 6.4f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.addEdge("terni", "firenze", 11.3f));
		assertTrue(g.addEdge("firenze", "terni", 6.4f));
		assertTrue(g.addEdge("ancona", "firenze", 11.1f));
		assertTrue(Float.compare(g.getLabel("terni", "firenze"),  11.3f) == 0);
		assertTrue(Float.compare(g.getLabel("terni", "ancona"),  11.1f) == 0);
		assertTrue(Float.compare(g.getLabel("ancona", "firenze"),  11.1f) == 0);
		assertTrue(Float.compare(g.getLabel("roma", "firenze"),  6.3f) == 0);
	}

	@Test
	public void testGetLabel2(){
		Graph<String, Float> g = new Graph<>(true, false);
		ArrayList<String> checkerN = new ArrayList<>();
		checkerN.add("roma");checkerN.add("ancona");checkerN.add("firenze");checkerN.add("terni");
		ArrayList<Edge<String, Float>> checker = new ArrayList<>();
		Edge<String, Float> e1 = new Edge<>("roma", "ancona", 72.3f);
		Edge<String, Float> e2 = new Edge<>("ancona", "roma", 60.3f);
		Edge<String, Float> e3 = new Edge<>("roma", "terni", 50.3f);
		Edge<String, Float> e4 = new Edge<>("roma", "firenze", 6.3f);
		Edge<String, Float> e5 = new Edge<>("terni", "ancona", 11.1f);
		Edge<String, Float> e6 = new Edge<>("terni", "firenze", 11.1f);
		Edge<String, Float> e7 = new Edge<>("firenze", "terni", 31.1f);
		checker.add(e1);checker.add(e2);checker.add(e3);checker.add(e4);checker.add(e5);checker.add(e6);checker.add(e7);
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("firenze", "roma", 6.4f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.addEdge("terni", "firenze", 11.3f));
		assertTrue(g.addEdge("firenze", "terni", 6.4f));
		assertTrue(g.addEdge("ancona", "firenze", 11.1f));
		assertTrue(g.getLabel("terni", "firenze") == null);
		assertTrue(g.getLabel("terni", "ancona") == null);
		assertTrue(g.getLabel("ancona", "firenze") == null);
		assertTrue(g.getLabel("roma", "firenze") == null);
	}

	@Test
	public void testGetNeighboursDir(){
		Graph<String, Float> g = new Graph<>(true, false);
		ArrayList<String> checkerN = new ArrayList<>();
		ArrayList<String> checkerN2 = new ArrayList<>();
		checkerN.add("ancona");checkerN.add("terni");checkerN.add("firenze");
		checkerN2.add("ancona");checkerN2.add("terni");
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("firenze", "roma", 6.4f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.addEdge("terni", "firenze", 11.3f));
		assertTrue(g.addEdge("firenze", "terni", 6.4f));
		assertTrue(g.addEdge("ancona", "firenze", 11.1f));
		assertTrue(g.getNeighbours("roma").equals(checkerN));
		assertTrue(g.removeEdge("roma", "firenze"));
		assertTrue(g.getNeighbours("roma").equals(checkerN2));
	}

	@Test
	public void testGetNeighboursNonDir(){
		Graph<String, Float> g = new Graph<>(false, false);
		ArrayList<String> checkerN = new ArrayList<>();
		ArrayList<String> checkerN2 = new ArrayList<>();
		ArrayList<String> checkerN3 = new ArrayList<>();
		checkerN.add("ancona");checkerN.add("terni");checkerN.add("firenze");
		checkerN2.add("ancona");checkerN2.add("terni");
		checkerN3.add("terni");checkerN3.add("ancona");
		assertTrue(g.addNode("ancona"));
		assertTrue(g.addNode("roma"));
		assertTrue(g.addNode("firenze"));
		assertTrue(g.addNode("terni"));
		assertTrue(g.addEdge("roma", "ancona", 72.3f));
		assertTrue(g.addEdge("roma", "terni", 50.3f));
		assertTrue(g.addEdge("roma", "firenze", 6.3f));
		assertTrue(g.addEdge("terni", "ancona", 11.1f));
		assertTrue(g.addEdge("firenze", "terni", 6.4f));
		assertTrue(g.addEdge("ancona", "firenze", 16.7f));
		assertTrue(g.getNeighbours("roma").equals(checkerN));
		assertTrue(g.removeEdge("roma", "firenze"));
		assertTrue(g.getNeighbours("roma").equals(checkerN2));
		assertTrue(g.removeNode("roma"));
		assertTrue(g.getNeighbours("roma") == null);
		assertTrue(g.getNeighbours("firenze").equals(checkerN3));
	}

}