package Ass6_BSST_Index;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author: Sam Florin
 * Created: 2018-09-26
 * Description: Count the most frequent word inputted using a BST or an ordered array ST
 */

public class FrequencyCounter {
    public static void main(String[] args) {
        int counter2 = 0;
        int counter = 0;
        int index = 0;
        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        LinkedList<String, Integer> indexList = new LinkedList<>();

        while (!StdIn.isEmpty() && counter2 < 1000)
        { // Build symbol table and count frequencies.

            String word = StdIn.readString().toLowerCase();
            if (!st.contains(word)) {
                st.put(word, 1);
                counter++;
            }
            else st.put(word, st.get(word) + 1);
            counter2++;
            if(index == 0) {
                indexList.enqueue(word, index);
            } else {
                indexList.enqueue(word, index + 1);
            }
        }


        /*
        long startTime = System.nanoTime();
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        StdOut.println(totalTime);
        */
    }
}
