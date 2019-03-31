/**
 * Author: Sam Florin
 * Created: 2018-10-10
 * Description: Main - Class  - Test P1Ass3
 * */
package ass4;
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
        String Y = "UT";
        int source = sg.indexOf(X);
        int target = sg.indexOf(Y);

        PrimMST prim = new PrimMST(graph);
        double w1 = 0;
        for(Edge e : prim.edges()) {
            StdOut.println(e.toString(sg));
            w1 = w1 + e.weight();
        }
        StdOut.println(w1);
    }
}
