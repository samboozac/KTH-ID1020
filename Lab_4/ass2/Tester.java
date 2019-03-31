/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Main - Class  - Test P1Ass2
 * */
package ass2;
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
        String Y = "IN";
        int source = sg.indexOf(X);
        int target = sg.indexOf(Y);
        // BreadthFirstSearch
        BFS bfs = new BFS(graph, source);
        // Print the shortest path between the X and Y
        StdOut.println(bfs.pathTo(sg, target));
    }
}
