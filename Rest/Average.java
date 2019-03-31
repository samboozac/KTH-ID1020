/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description: Modified example from Robert Sedgewick's and Kevin Wayne's book, Algorithms: https://algs4.cs.princeton.edu/code/
***/
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class Average {
    private Average() { }
    public static void main(String[] args) {
        int count = 0;
        double sum = 0.0;
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            count++;
        }
        double average = sum / count;
        StdOut.println("Average is " + average);
    }
}
