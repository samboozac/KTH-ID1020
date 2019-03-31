/**
 * Author: Sam Florin
 * Created: 2018-10-10
 * Description: Main - Class  - Test P1Ass3
 * */
package ass3;
import edu.princeton.cs.algs4.StdOut;

public class Tester {
    public static final String FILENAME = "https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat";
    public static final String DELIMITER = " ";
    public static void main(String[] args) {
        // Setup
        int numOfV = 49;
        int numOfE = 107;
        SymbolGraph sg = new SymbolGraph(FILENAME, DELIMITER);
        EdgeWeightedGraph graph = sg.graph();
        // Query
        String X = "AL";
        String Y = "IN";
        int source = sg.indexOf(X);
        int target = sg.indexOf(Y);

        DijkstraSP dijk = new DijkstraSP(graph, source);
        StdOut.println(dijk.distTo(target));
        StdOut.println(dijk.pathTo(target));

        // How to print the edges best?
        // Illustrate Edges, HELP!
        for(Edge e : dijk.pathTo(target)) {
            StdOut.print(e.toString(sg) + "--> ");
        }
        //StdOut.println(graph.toString(sg));
    }
}
