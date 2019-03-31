/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Undirected graph Implementation
 * */
package ass1;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Graph {
    // Instance variables
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    // Constructor
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    // Builds the ass1.Graph from input Stream, V: num of Vertices, E: num of Edges
    public Graph(In in) {
            this.V = in.readInt();
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }
        }
    // New ass1.Graph that is a copy of G
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    // Adds the undirected Edge v-w to the ass1.Graph
    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    // Helper Methods
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    // Represent the ass1.Graph
    public String toString(SymbolGraph sg) {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(sg.name(v) + ": ");
            for (int w : adj[v]) {
                s.append(sg.name (w)+ " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
