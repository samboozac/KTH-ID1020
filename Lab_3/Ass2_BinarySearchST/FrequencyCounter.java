package Ass2_BinarySearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author: Sam Florin / Algorithms - Sedgewick, Wayne
 * Created: 2018-09-26
 * Description: Count the most frequent word inputted using a BST or an ordered array ST
 */

public class FrequencyCounter {
    public static void main(String[] args) {
        int counter = 0;
        final int NUM_OF_WORDS = 1000;

        // Create structure
        BinarySearchST<String, Integer> st = new BinarySearchST<>();

        long startBuildTime = System.nanoTime();
        // Build Symbol Table [First 1000 words]
        while (!StdIn.isEmpty() && counter < NUM_OF_WORDS) {
            String word = StdIn.readString().toLowerCase();
            if (!st.contains(word)) {
                st.put(word, 1);
            }
            else st.put(word, st.get(word) + 1);
            counter++;
        }
        // End build time
        long endBuild = System.nanoTime();
        long totBuildTime = endBuild - startBuildTime;

        // Time Search
        long startTime = System.nanoTime();
        // Read words
        for (String s : st.keys()) {
            StdOut.print(s + ": ");
            StdOut.println(st.get(s));
        }

        // End Timer, print
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        StdOut.println("Build time: " + totBuildTime);
        StdOut.println("Read time: " + totalTime);
    }
}
