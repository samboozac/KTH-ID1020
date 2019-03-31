/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description:
***/
import java.util.Arrays;
import java.util.Scanner;

public class StringChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a length of the array: ");
        int len = sc.nextInt();
        System.out.println("Good!");
        char [] carr = new char[len];

        int i = 0;
        while(sc.hasNextLine()){
            carr[i] = sc.next().charAt(0);
            System.out.println(Arrays.toString(carr));
            i++;
        }
    }
}
