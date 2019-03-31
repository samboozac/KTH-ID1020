/*Smart way to implement an algorithm*/
/*Implement a specific algorithm in the static method 'sort'*/
/*Effective 'helpers' */
/*Show, isSorted?, ...*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Selection {
    private Selection() { }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, comparator, 0, i);
        }
        assert isSorted(a, comparator);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // isSorted (recursive)
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the length of the Array: ");
        int len = scan.nextInt();
        System.out.println("Good, enter " + len + " elements");
        String[] arr = new String[len];
        int i = 0;
        while(scan.hasNextLine() && i < len) {
            arr[i] = scan.next();
            i++;
        }
        System.out.println(Arrays.toString(arr));
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
        show(arr);
    }
}
