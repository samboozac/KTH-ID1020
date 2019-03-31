package Ass6_B_ST_Index_Simp;
import java.util.Scanner;

/**
 * Author: Sam Florin
 * Created: 2018-09-26
 * Description: Display the index of a certain word
 */

public class IndexCounterSimple {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next().toLowerCase();
        String selectedWord = "the";
        int counter = 0;

        // print directly, not so quick. O(N) + ...
        while(sc.hasNextLine()) {
            if(selectedWord.equals(input)) {
                System.out.println("'" + input + "'" + " found on Index: " + counter);
            }
            input = sc.next().toLowerCase();
            counter++;
        }
    }
}
