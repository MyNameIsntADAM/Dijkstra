package algorithm;

public class Node {
	private String name;
	private Double distance = Double.MAX_VALUE;
	private Node previous = null;
	
	public Node(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public Double getDistance() {
		return distance;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node n) {
		previous = n;
	}
	
	public void setDistance(Double d) {
		distance = d;
	}
	
	public boolean equals(Node n) {
		return n.toString().equals(name);
	}
}
