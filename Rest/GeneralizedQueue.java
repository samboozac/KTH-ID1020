/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description: Modified example from Robert Sedgewick's and Kevin Wayne's book, Algorithms: https://algs4.cs.princeton.edu/code/
***/
import java.util.NoSuchElementException;

public class GeneralizedQueue<Item> {
    private Node first;
    private Node last;
    private int size;

    public GeneralizedQueue() {
        size = 0;
    }

    private class Node {
        Item element;
        Node next;
        Node prev;

        public Node(Item element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public ListIterator iterator(){
        return new ListIterator();
    }

    private class ListIterator {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = first;
        }

        public Item next() {
            Item element = current.element;
            current = current.next;
            return element;
        }
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void enQueue(Item element) {
        Node temp = new Node(element, first, null);
        if (first != null) {first.prev = temp;}
        first = temp;
        if (last == null) {last = temp;}
        size++;
    }

    public void deQueue() {
        if (size == 0) throw new NoSuchElementException();
        Node temp = last;
        last = last.prev;
        last.next = null;
        size--;
    }

    public  void deleteElement(int k) {
        ListIterator it = new ListIterator();
        int i = 1;
        while (i < k) {
            it.next();
            i++;
        }
        it.remove();
        size--;
    }

    public void printString() {
        ListIterator it = new ListIterator();
        int i = 0;
        while(i < size) {
            System.out.print("|" +it.current.element + "|");
            it.next();
            i++;
        }
    }
}
