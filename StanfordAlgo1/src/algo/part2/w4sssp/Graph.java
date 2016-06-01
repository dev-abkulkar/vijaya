package algo.part2.w4sssp;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Edge> edges = new ArrayList<Edge>();
	private int nodes;
	
	public Graph(List<Edge> edges, int nodes) {
		this.edges = edges;
		this.nodes = nodes;
	}
	
	public void addEdge(Edge e) {
		if (this.edges == null) {
			this.edges = new ArrayList<Edge>();
		}
		this.edges.add(e);
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	public int getNodes() {
		return this.nodes;
	}
	
}
