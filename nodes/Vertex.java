package nodes;

import java.util.ArrayList;

public class Vertex {
	public int value;
	public ArrayList<Vertex> adjacent;
	
	public Vertex(int num) {
		value = num;
		adjacent = new ArrayList<Vertex>();
	}
	
	public void printNeighbors() {
		for (Vertex node : adjacent) {
			System.out.print(node.value + " ");
		}
	}
}
