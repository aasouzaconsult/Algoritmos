import java.util.*;
import Node

// AdjacencyList class implements AdjacencyList using a linked list structure.
public class AdjacencyList {	
	private int[] adj;

	public AdjacencyList(int vertices) {
		adj = new int[vertices];
		for(int i=0; i<vertices; i++) {
			Node node = new Node(null);
			adj[i] = node;
		}
	}

	public void addNode(int vertex, int adj_vertex) {
		index = offset(vertex);

		while (adj[index].next != null) {
			adj[index] = adj[index].next;
		}
		Node temp = new Node(adj_vertex);
		adj[index].next = temp;
	}

	public void deleteNode(int vertex, int adj_vertex) {
		index = offset(vertex);

		while(adj[index].data != adj_vertex) {
			prev = adj[index];
			adj[index] = adj[index].next;
		}
		if (adj[index].data == adj_vertex) {
			prev.next = adj[index].next;
			adj[index] = null;
		}
	}

	public void degree(int[] adj) {
		for(int i=0; i < adj.size(); i++) {
			count = 0;			
			while (adj[i] != null) {
				count += 1;
				adj[i] = adj[i].next;
			}
			System.out.println("Vertex" + i + " has degree " + count);
		}
	}

	private static int offset(int vertex) {
		//vertex offset
		return vertex - 1;
	}
}