/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Symbol graph implementation
 * */
package ass4;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
    private ST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private EdgeWeightedGraph graph;             // the underlying graph
    // Constructor
    public SymbolGraph(String stream, String sp) {
        st = new ST<String, Integer>();
        // First pass
        In in = new In(stream);
        // Build the index, associate each distinct String with an index
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        // Get String keys in an array
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        // Second pass, build the GRAPH
        graph = new EdgeWeightedGraph(st.size());
        in = new In(stream);
        // Connecting first vertex on each line to all the others
        int weight = 1;
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                // Give each Edge a unique weight for easier check.
                Edge en = new Edge(v, st.get(a[i]), weight++);
                graph.addEdge(en);
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
    public EdgeWeightedGraph G() {
        return graph;
    }
    // Returns the ass1.Graph associated with the Symbol ass1.Graph
    public EdgeWeightedGraph graph() {
        return graph;
    }
}