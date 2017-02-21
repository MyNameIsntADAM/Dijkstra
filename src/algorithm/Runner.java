package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
	
	public static final int startX = 1, startY = 1, 
							endX = 17, endY = 9;
	
	private List<Node> nodes;
	private List<Edge> edges;
	
	private List<String> streetNames;
	
	public void testExecute() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		streetNames = new ArrayList<String>();
		
		getStreetNames("src/res/Street_Names.txt");
		getEdges("src/res/edges.txt");
		
        Astar a = new Astar(new Graph(nodes, edges));
        Node start = getNode(startX, startY);
        Node end = getNode(endX, endY);
        
        //Calculate shortest path to given node for all nodes.
        a.run(start, end);
	}

	/*
	 * @param name the name of the edge
	 * @param start the index of the edge's first node
	 * @param end the index of the edge's connecting node
	 */
	private Edge addEdge(String name, Node start, Node end) {
		Edge edge = new Edge(name, start, end, Node.distanceFrom(start, end));
		edges.add(edge);
		return edge;
	}
	
	private void getEdges(String path) {
		FileReader file;
		try {
			file = new FileReader(path);
			BufferedReader reader = new BufferedReader(file);
			String line = null;
			//Parse text file to create Edges
			Random r = new Random();
			while((line = reader.readLine()) != null) {
				String[] arr = line.split(";");
				String name = streetNames.get(r.nextInt(streetNames.size()));
				//This is an Edge
				if(arr.length > 2) {
					Node start = new Node("" + Integer.parseInt(arr[0]) + ", " + Integer.parseInt(arr[1]), Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
					Node end = new Node("" + Integer.parseInt(arr[2]) + ", " + Integer.parseInt(arr[3]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
					//Check if nodes already contains the start or end node. If so, set start and end equal to the found node.
					boolean startAdded = false;
					boolean endAdded = false;
					for(Node n : nodes) {
						if(start.equals(n)) {
							start = n;
							startAdded = true;
						}
						if(end.equals(n)) {
							end = n;
							endAdded = true;
						}
					}
					if(!startAdded) nodes.add(start);
					if(!endAdded) nodes.add(end);
					addEdge(name, start, end);
				}
				//This is a Node with no outgoing edges
				else {
					Node node = new Node("" + Integer.parseInt(arr[0]) + ", " + Integer.parseInt(arr[1]), Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
					nodes.add(node);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Node getNode(int x, int y) {
		Node node = new Node("", x, y);
		for(Node n : nodes) {
			if(node.equals(n)) {
				return n;
			}
		}
		return null;
	}
	
	private void getStreetNames(String path) {
		try {
			FileReader file = new FileReader(path);
			BufferedReader reader = new BufferedReader(file);
			String line = null;
			while((line = reader.readLine()) != null) {
				streetNames.add(line.split(",")[0]);
			}
			file.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Runner().testExecute();
	}
	
}
