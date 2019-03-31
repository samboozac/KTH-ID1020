/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description:
***/
import java.util.Arrays;
import java.util.Scanner;

public class ScannerLineInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);                      /*Initialize the Scanner called 'scan'*/
        System.out.println("Enter the length of the Array: ");      /*Instruction to standard output*/
        int i = scan.nextInt();                                     /*Reads until 'nextInt'*/
        int[] arr = new int[i];                                     /*Declares an array with i elements*/
        int j = 0;                                                      /*Reusing the var i*/
        while(scan.hasNextLine()) {
            arr[j] = scan.nextInt();                                /*Feed the array with Int's*/
            System.out.println(Arrays.toString(arr));
            j++;
        }
    }

}
