/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Main - Class  - Test P1Ass1
 * */
package ass1;
import edu.princeton.cs.algs4.StdOut;

public class Tester {
    public static final String FILENAME = "https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat";
    public static final String DELIMITER = " ";

    public static void main(String[] args) {
        // Setup
        SymbolGraph sg = new SymbolGraph(FILENAME, DELIMITER);
        Graph graph = sg.graph();
        // Query
        String X = "AL";
        String Y = "FL";
        // Convert the names into the  underlying index
        int source = sg.indexOf(X);
        int target = sg.indexOf(Y);
        // DepthFirstSearch
        DFS dfs = new DFS(graph, source);
        // Print the Path resulted in the DFS if it exists
        StdOut.println(dfs.pathTo(sg, target));
        //StdOut.println(graph.toString(sg));
    }
}