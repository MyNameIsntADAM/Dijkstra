package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	
	private static final int start = 0, end = 2;
	private List<Node> nodes;
	private List<Edge> edges;
	
	public void testExecute() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		
		/*Dijkstra's Stuff
		for(int i = 0; i < 12; i++) {
			//Node location = new Node("Node_" + i, (int)(Math.random()*200), (int)(Math.random()*200));
			Node location = new Node("Node_" + i, 1, i);
			nodes.add(location);
		}
		addEdge("Edge_0", 0, 1);
		addEdge("Edge_1", 0, 2);
		addEdge("Edge_2", 0, 4);
		addEdge("Edge_3", 2, 6);
		addEdge("Edge_4", 2, 7);
		addEdge("Edge_5", 3, 7);
		addEdge("Edge_6", 5, 8);
		addEdge("Edge_7", 8, 9);
		addEdge("Edge_8", 7, 9);
		addEdge("Edge_9", 4, 9);
		addEdge("Edge_10", 9, 10);
		addEdge("Edge_11", 1, 10);
		addEdge("Edge_12", 5, 11);
		addEdge("Edge_13", 2, 11);
		addEdge("Edge_13", 4, 11);
		addEdge("Edge_14", 1, 0);
		addEdge("Edge_15", 9, 11);
		*/
		nodes.add(new Node("Node_A", 1, 5));
		nodes.add(new Node("Node_B", 3, 5));
		nodes.add(new Node("Node_C", 5, 1));
		addEdge("Edge_AB", 0, 1);
		addEdge("Edge_BC", 1, 2);
		addEdge("Edge_AC", 0, 2, 100.0);
		
        Graph graph = new Graph(nodes, edges);
        //Dijkstra dijkstra = new Dijkstra(graph);
        Astar a = new Astar(graph);
        //Calculate shortest path to given node for all nodes.
        //dijkstra.run(nodes.get(start), nodes.get(end));
        a.run(nodes.get(start),  nodes.get(end));
	}

	/*
	 * @param name the name of the edge
	 * @param start the index of the edge's first node
	 * @param end the index of the edge's connecting node
	 * @param length the weight of the edge
	 */
	private Edge addEdge(String name, int start, int end) {
		Edge edge = new Edge(name, nodes.get(start), nodes.get(end), Node.distanceFrom(nodes.get(start), nodes.get(end)));
		edges.add(edge);
		return edge;
	}
	
	private Edge addEdge(String name, int start, int end, Double length) {
		Edge edge = new Edge(name, nodes.get(start), nodes.get(end), length);
		edges.add(edge);
		return edge;
	}
	
	public static void main(String[] args) {
		new Runner().testExecute();
	}
	
}
