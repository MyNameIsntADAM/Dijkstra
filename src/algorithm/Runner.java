package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	
	private List<Node> nodes;
	private List<Edge> edges;
	
	public void testExecute() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		for(int i = 0; i < 12; i++) {
			Node location = new Node("Node_" + i);
			nodes.add(location);
		}
		addEdge("Edge_0", 0, 1, 234);
		addEdge("Edge_1", 0, 2, 223);
		addEdge("Edge_2", 0, 4, 173);
		addEdge("Edge_3", 2, 6, 17);
		addEdge("Edge_4", 2, 7, 1343);
		addEdge("Edge_5", 3, 7, 75);
		addEdge("Edge_6", 5, 8, 630);
		addEdge("Edge_7", 8, 9, 884);
		addEdge("Edge_8", 7, 9, 147);
		addEdge("Edge_9", 4, 9, 512);
		addEdge("Edge_10", 9, 10, 40);
		addEdge("Edge_11", 1, 10, 50);
		addEdge("Edge_12", 5, 11, 243);
		addEdge("Edge_13", 2, 11, 122);
		addEdge("Edge_13", 4, 11, 9);
		addEdge("Edge_14", 1, 0, 22);
		
        Graph graph = new Graph(edges);
        Dijkstra dijkstra = new Dijkstra(graph);
      
        //Calculate shortest path to given node for all nodes.
        dijkstra.run(nodes.get(1), nodes.get(0));
	}

	/*
	 * @param name the name of the edge
	 * @param start the index of the edge's first node
	 * @param end the index of the edge's connecting node
	 * @param length the weight of the edge
	 */
	private Edge addEdge(String name, int start, int end, double length) {
		Edge edge = new Edge(name, nodes.get(start), nodes.get(end), length);
		edges.add(edge);
		return edge;
	}
	
	public static void main(String[] args) {
		new Runner().testExecute();
	}
	
}
