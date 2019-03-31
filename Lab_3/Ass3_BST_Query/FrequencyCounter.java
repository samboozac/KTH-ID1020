package Ass3_BST_Query;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * OK
 * Author: Sam Florin
 * Created: 2018-09-26
 * Description: Count the most frequent word inputted using a BST or an ordered array ST
 */

public class FrequencyCounter {
    public static void main(String[] args) {
        // Vars
        int sizeCapacity = 0;
        int uniqueWords = 0;

        BST<String, Integer> st = new BST<>();

        // TIme the build
        long startBuildTime = System.nanoTime();
        // Read input
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString().toLowerCase();
            if (!st.contains(word)) {
                st.put(word, 1);
                uniqueWords++;
            }
            else st.put(word, st.get(word) + 1);
        }
        long endBuild = System.nanoTime();
        long totBuildTime = endBuild - startBuildTime;


        // Insert unique words in the array
        String[] arrayK = new String[uniqueWords];
        int k = 0;
        long startTime = System.nanoTime();

        for (String word : st.keys()) {
            arrayK[k] = word;
            k++;
        }

        // Sort the array after value [Modified Quick-sort]
        // Reference to Tree is sent as parameter to use the get-function
        Quick.sort(arrayK, st);
        final int roof = arrayK.length-5;

        // Print interval
        for(int i = roof-100; i <= roof; i++){
            StdOut.println(arrayK[i]);
        }

        // Timer, compare with Red Black ST

        // Print all
        for(int i = arrayK.length-1; i > 0; i--) {
            StdOut.println(i + ": " + arrayK[i] + "||" + st.get(arrayK[i]));
        }

        // End time, print result
        long endTime   = System.nanoTime();
        long totTime = endTime - startTime;

        StdOut.println("Access/print: " + totTime);
        StdOut.println("Build time: " + totBuildTime);
    }
}
