package Ass4_RedBlack;

public class RedBlack<Key extends Comparable<Key>, Value> {

    // Connections
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    // Member  class 'Helper class'
    private class Node {
        // Instance variables
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int size;

        // Constructor
        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    // Constructor
    public RedBlack() {}

    // Check connection color, True for RED
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // Return size of Node x
    private int size(Node x){
        if (x == null) return 0;
        return x.size;
    }

    // Return size of Tree
    public int size() {
        return size(root);
    }
    // Check if Tree is empty, return True if so.
    public boolean isEmpty() {
        return root == null;
    }
    // Check if key contains a value
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // Get the value associated with the inputted KEY.
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        // Search the Tree
        while (x != null) {
            // compare KEYS, a.compareTo(b) ret. 1 if a > b
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    // Insert a new Node
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            return;
        }
        // Call helper with current root.
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val) {
        // Find bottom, if h == null, add new RED connection
        if (h == null) return new Node(key, val, RED, 1);
        // If Key > h.key --> compareTo ret. 1
        int cmp = key.compareTo(h.key);
        // if key < h.key --> compareTo ret. -1
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        // if compareTo ret. 0 --> increment value.
        else h.val = val;

        // Balance the Tree Immediately
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h); // Right leaning RED fix
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h); // RED streak fix
        if (isRed(h.left) && isRed(h.right)) flipColors(h); // RED twins fix
        h.size = size(h.left) + size(h.right) + 1;  // increment size, to the roots.
        return h;   // Return new node
    }

    // Maintain a balance, get headache
    // If we have 2 RED ina row
    // Please Paint me
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    // Fix a right leaning RED.
    // Please Paint me
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    // If left and right RED, flip color!
    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    // Recursively call the min KEY
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    // Recursively call the max KEY
    public Key max() {
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }

    // Returns an iterable Queue of keys
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<>();
        return keys(min(), max());
    }

    // Returns an iterable interval of keys
    public Iterable<Key> keys(Key lo, Key hi) {
         Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}