/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description: Modified example from Robert Sedgewick's and Kevin Wayne's book, Algorithms: https://algs4.cs.princeton.edu/code/
***/
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class RandomSeq {
    private RandomSeq() { }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        if (args.length == 1) {
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform();
                StdOut.println(x);
            }
        }

        else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);

            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform(lo, hi);
                StdOut.printf("%.2f\n", x);
            }
        }

        else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
}
