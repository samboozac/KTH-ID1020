package Ass4_RedBlack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * OK
 * Author: Sam Florin / Algorithms - Sedgewick, Wayne
 * Created: 2018-09-26
 * Description: Most Frequent Query
 */

public class FrequencyCounter {
    public static void main(String[] args) {
        int counter = 0;
        RedBlack<String, Integer> st = new RedBlack<>();

        long startTime2 = System.nanoTime();
        while (!StdIn.isEmpty())
        { // Build symbol table and count frequencies.
            String word = StdIn.readString().toLowerCase();
            if (!st.contains(word)) {
                st.put(word, 1);
                counter++;
            }
            else st.put(word, st.get(word) + 1);
        }
        long endTime2   = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;

        String[] arrayK = new String[counter];
        int k = 0;
        long startTime = System.nanoTime();
        for (String word : st.keys()) {
            arrayK[k] = word;
            k++;
        }
        Quick.sort(arrayK, st);

        // print 100 most print
        for(int i = 0; i <= arrayK.length-1; i++){
            StdOut.println(arrayK[i]);
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        StdOut.println(totalTime);
        StdOut.println("Build: " + totalTime2);

        // Print all the words! [Assign 4]
        /*
        for(int i = arrayK.length-1; i > 0; i--) {
            StdOut.println(i + ": " + arrayK[i] + "||" + st.get(arrayK[i]));
        }
        */
    }
}
