package Ass2_BinarySearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author: Sam Florin
 * Created: 2018-09-26
 * Description: Ordered Array Symbol Table API
 */

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int NUM_OF_STRING_TO_INPUT = 1000;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    public BinarySearchST() {
        this(NUM_OF_STRING_TO_INPUT);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    }

    // Binary search the number of keys larger than key.
    public int rank(Key key) {
        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value val)  {
        // Binary search the index
        int i = rank(key);
        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Key min() {
        return keys[0];
    }
    public Key max() {
        return keys[n-1];
    }

    public Iterable<Key> keys() { return keys(min(), max());}

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0) {
            return queue;
        }
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> table = new BinarySearchST<>();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if(!table.contains(s)) {
                table.put(s, 1);
            } else {
                table.put(s, table.get(s) + 1);
            }
        }
        for(String s : table.keys()) {
            StdOut.println(s + " " + table.get(s));
        }
    }
}