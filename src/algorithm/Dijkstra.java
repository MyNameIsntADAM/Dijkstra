package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dijkstra {
	
	/*
	 * This implementation of Dijkstra's algorithm updates all nodes in a graph with their shortest distance/path to a given node
	 */
	
	private Graph graph;
	private List<Edge> edges;
	private Set<Node> unsearched;
	private Set<Node> searched;
	
	public Dijkstra(Graph graph) {
		this.graph = graph;
		resetGraph();
	}
	
	/*
	 * Clears all edges;
	 */
	private void resetGraph() {
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}
	
	/*
	 * Finds and prints shortest path from start to end
	 */
	public void run(Node start, Node end) {
		
		unsearched = new HashSet<Node>();
		searched = new HashSet<Node>();
		
		Node current = start;		//Start the search with @param start
		start.setDistance(0.0);
		unsearched.add(start);
		
		while(!unsearched.isEmpty()) {
			//Check if current is our target destination. If so, print out the path and end the function.
			if(current.equals(end)) {
				Node.printPath(end);
				return;
			}

			//Set current to the node with the least distance to start
			current = getClosest();
			searched.add(current);
			unsearched.remove(current);
			updateNeighborDistances(current);
		}
		//We did not find the shortest path.
		System.out.println("Shortest path between " + start + " and " + end + " was not found.");
	}
	
	/*
	 * Updates all nodes with shortest distance from start. printPath(end) must be called separately.
	 */
	public void run(Node start) {
		
		unsearched = new HashSet<Node>();
		searched = new HashSet<Node>();
		
		Node current = start;		//Set the current node to start
		start.setDistance(0.0);		//
		unsearched.add(start);
		
		while(!unsearched.isEmpty()) {
			//Set current to the node with the least distance to start
			current = getClosest();
			searched.add(current);
			unsearched.remove(current);
			updateNeighborDistances(current);
		}
	}
	
	/*
	 * @param curr the node whose neighbors we will update
	 */
	private void updateNeighborDistances(Node curr) {
		List<Node> neighbors = Graph.getNeighbors(edges, curr);
		Double distance = curr.getDistance();
		for(Node neighbor : neighbors) {
			//Updates distances for nodes that neighbor @param curr
				Double temp = Graph.getDistanceFrom(edges, curr, neighbor);
				if(distance + temp < neighbor.getDistance()) {
					neighbor.setPrevious(curr);
					neighbor.setDistance(distance + temp);
					unsearched.add(neighbor);
				}
		}
	}
	
	/*
	 * @return the unsearched node with the shortest path to the start
	 */
	private Node getClosest() {
		Node closest = null;
		for(Node node : unsearched) {
				if(closest == null) {
					closest = node;
				}
				else {
					if(node.getDistance() < closest.getDistance()) {
						closest = node;
					}
				}
		}
		return closest;
	}
	
	
}
