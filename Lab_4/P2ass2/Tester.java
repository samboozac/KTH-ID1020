/**
 * Author: Sam Florin
 * Created: 2018-10-09
 * Description: Main - Class  - Test P2Ass2
 * */
package P2ass2;
import edu.princeton.cs.algs4.StdOut;

public class Tester {
    public static final String FILENAME = "https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat";
    public static final String DELIMITER = " ";

    public static void main(String[] args) {
        // Setup
        SymbolGraph sg = new SymbolGraph(FILENAME, DELIMITER);
        DirectedGraph graph = sg.graph();
        // Query
        String X = "NC";
        String Y = "AL";
        int xx = sg.indexOf(X);
        int yy = sg.indexOf(Y);
        // Add edge to create a cycle
        graph.addEdge(xx,yy);

        // BreadthFirstSearch
        DirectedCycle dc = new DirectedCycle(graph);
        StdOut.println(dc.hasCycle());

        for(int i : dc.cycle()) {
            StdOut.print(sg.name(i) + "--> ");
        }
    }
}
