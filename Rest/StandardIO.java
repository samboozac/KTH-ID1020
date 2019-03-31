/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description:
***/
import java.util.Scanner;

public class StandardIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            sc.nextInt();
            System.out.print("Hello");
        }
    }
}
