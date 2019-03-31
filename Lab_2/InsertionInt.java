import java.util.Scanner;

public class InsertionInt {

     static void sort(int[] arr) {
        int i,j,current;
        int swaps=0;
        for(i = 0; i < arr.length; i++){
            current = arr[i];
            j = i-1;
            while(j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                swaps++;
                show(arr);
                System.out.println("Swaps: " + swaps);
                j--;
            }
            arr[j+1] = current;
        }
    }

    private static void show(int[] a) {
        StringBuilder sb = new StringBuilder(" ");
        sb.append("[");
        for (int i = 0; i < a.length; i++) {
            if(i != a.length-1) {
                sb.append(a[i] + ", ");
            } else {
                sb.append(a[i]);
            }
        }
        sb.append("]");
        StdOut.println(sb);
    }

    public static void negate(int[] a) {
         for(int i = 0; i < a.length; i++) {
             a[i] = a[i]*(-1);
         }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the length of the Array: ");
        int len = scan.nextInt();
        System.out.println("Good, enter " + len + " elements");
        int[] arr = new int[len];
        int i = 0;
        int swaps = 0;
        while(scan.hasNextLine() && i < len) {
            arr[i] = scan.nextInt();
            swaps++;
            i++;
        }
        show(arr);
        InsertionInt.sort(arr);
        show(arr);

        negate(arr);
        InsertionInt.sort(arr);
        negate(arr);
        show(arr);

        System.out.println(swaps);

    }
}
