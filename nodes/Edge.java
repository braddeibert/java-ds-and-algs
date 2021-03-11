package nodes;

import nodes.Vertex;

public class Edge {

	public int weight;
	private Vertex connected[];
	
	public Edge(int num, Vertex a, Vertex b) {
		connected = new Vertex[]{a, b};
		weight = num;
	}
	
	public Vertex[] getVertices() {
		return connected;
	}
}
