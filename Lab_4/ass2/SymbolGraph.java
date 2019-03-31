/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Symbol graph implementation
 * */
package ass2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    private ST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Graph graph;             // the underlying graph
    // Constructor
    public SymbolGraph(String stream, String sp) {
        st = new ST<String, Integer>();
        // First pass
        In in = new In(stream);
        // Build the index, associate each distinct String with an index
        while (!in.isEmpty()) {
            // If delimiter(sp) split! - Index all the Vertices
            String[] a = in.readLine().split(sp);
            // Add all the vertices to the Symbol Table
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        // Get String keys in an array ("invert" key-value)
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        // Second pass, build the GRAPH
        graph = new Graph(st.size());
        in = new In(stream);
        // Connecting first vertex on each line to all the others
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                graph.addEdge(v, st.get(a[i]));
            }
        }
    }
    // Helper Methods
    public boolean contains(String s) {
        return st.contains(s);
    }
    public int indexOf(String s) {
        return st.get(s);
    }
    public String name(int v) { return keys[v]; }

    // Return the underlying ass1.Graph
    public Graph G() {
        return graph;
    }
    // Returns the ass1.Graph associated with the Symbol ass1.Graph
    public Graph graph() {
        return graph;
    }
}