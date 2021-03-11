import java.util.ArrayList;
import java.util.Random;
import nodes.Vertex;
import nodes.Edge;

public class WeightedGraph {
	
	private ArrayList<Vertex> V;
	private ArrayList<Edge> E;

	public WeightedGraph() {
		V = new ArrayList<Vertex>();
		E = new ArrayList<Edge>();
	}
	
	public void addEdge(int weight, Vertex a, Vertex b) {
		if (!(V.contains(a) && V.contains(b))) {
			System.out.println("Error: at least one endpoint does not exist in the graph");
			return;
		}
		
		Edge e = new Edge(weight, a, b);
		E.add(e);
	}
	
	public void addVertex(Vertex a) {
		if (V.contains(a)) {
			System.out.println("Graph already contains vertex");
			return;
		}
		
		V.add(a);
	}
	
	public void primMST() {
		
	}
	
	public void kruskalMST() {
		
	}
	
	public void dikstraSP() {
		
	}
	
	public Vertex getVertex(int val) {
		for (Vertex v : V) {
			if (v.value == val) {
				return v;
			}
		}
		
		return null;
	}
	
	public void printVertices() {
		for (Vertex v : V) {
			System.out.println(v.value + " ");
		}
	}
	
	public void printEdges() {
		for (Edge e : E) {
			Vertex adj[] = e.getVertices();
			System.out.println(adj[0].value + "-" + adj[1].value + " (" + e.weight + ")" );
		}
	}
	
	public void printGraph() {
		System.out.println("Vertices: ");
		printVertices();
		
		System.out.println("Edges: ");
		printEdges();
	}
	
	// unit test with simple K4 graph
	public static void main(String args[]) {
		Random rand = new Random();
		WeightedGraph G = new WeightedGraph();
		
		for (int i = 0; i < 4; i++) {
			Vertex v = new Vertex(i);
			G.addVertex(v);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				G.addEdge(rand.nextInt(100), G.getVertex(i), G.getVertex(j));
			}
		}
		
		G.printGraph();
	}
}
