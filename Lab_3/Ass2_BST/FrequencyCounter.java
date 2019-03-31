package Ass2_BST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author: Sam Florin
 * Created: 2018-09-26
 * Description: Count the most frequent word inputted using a BST or an ordered array ST
 */

public class FrequencyCounter {
    public static void main(String[] args) {

        // vars
        int counter = 0;
        final int NUM_OF_WORDS = 1000;

        // create structure
        BST<String, Integer> st = new BST<>();


        long startBuildTime = System.nanoTime();
        // Build Binary Search Tree ST with the 1000 first words
        while (!StdIn.isEmpty() && counter < NUM_OF_WORDS)
        {
            String word = StdIn.readString().toLowerCase();
            if (!st.contains(word)) {
                st.put(word, 1);
            }
            else st.put(word, st.get(word) + 1);
            counter++;
        }
        long endBuild = System.nanoTime();
        long totBuildTime = endBuild - startBuildTime;

        // Time the reading/Search
        long startTime = System.nanoTime();
        // Read the words using the iterator, for-each
        for (String s : st.keys()) {
            StdOut.print(s + " ");
            StdOut.println(st.get(s));
        }

        // End timer, write to output stream
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        StdOut.println("Build time: " + totBuildTime);
        StdOut.println("Read time: " + totalTime);
    }
}
