/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Main - Class  - Test P2Ass1
 * */
package p2ass1;
import edu.princeton.cs.algs4.StdOut;

public class Tester {
    public static final String FILENAME = "https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat";
    public static final String DELIMITER = " ";
    public static void main(String[] args) {
        // Setup
        SymbolGraph sg = new SymbolGraph(FILENAME, DELIMITER);
        DirectedGraph graph = sg.graph();
        // Query
        String X = "AL";
        String Y = "FL";
        int source = sg.indexOf(X);
        int target = sg.indexOf(Y);
        // BreadthFirstSearch
        DFS dfs = new DFS(graph, source);

        StdOut.println(dfs.hasPathTo(target));
        StdOut.println(graph.toString(sg));
        StdOut.println(dfs.pathTo(sg, target));
    }
}
