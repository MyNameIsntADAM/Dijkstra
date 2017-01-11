package algorithm;

import java.util.List;

public class Graph {
	private List<Node> nodes;
	private List<Edge> edges;
	
	public Graph(List<Edge> edges) {
		this.edges = edges;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
}
