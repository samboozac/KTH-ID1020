/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Directed graph implementation
 * */
package p2ass1;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

public class DirectedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v

    public DirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    // Instead of adj[v].add(w) and adj[w].add(v) we have:
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) { return adj[v]; }

    public String toString(SymbolGraph sg) {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%s: ", sg.name(v)));
            for (int w : adj[v]) {
                s.append(String.format("%s ", sg.name(w)));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}

