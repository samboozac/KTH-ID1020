/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description:
***/
import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char c = sc.next().charAt(0);
        double d = sc.nextDouble();
        System.out.println("Consecutive Int's: "+ a + "," + b + " Char: " + c + " Double: " + d);
    }

}
