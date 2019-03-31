package Ass6_B_ST_Index;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Sam Florin / Algorithms - Sedgewick, Wayne
 * Created: 2018-09-26
 * Description: Display the index when a certain word appears
 */

public class IndexCounter {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toLowerCase();
        // Setup
        int counter = 0;
        ArrayList<String> list = new ArrayList<>();
        // Read O(N)
        while(sc.hasNext()) {
            list.add(counter, input);
            counter++;
            input = sc.next().toLowerCase();
        }
        // Word?
        String selectedWord = "the";
        // Search O(N)
        for(int i = 0; i < counter; i++) {
            if(list.get(i).equals(selectedWord))
                System.out.println(list.get(i).toUpperCase() + " found at pos: " + i);
        }
    }
}
