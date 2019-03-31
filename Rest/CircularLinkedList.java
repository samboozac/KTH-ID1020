/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description: Modified example from Robert Sedgewick's and Kevin Wayne's book, Algorithms: https://algs4.cs.princeton.edu/code/
***/
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> {
    private Node first;
    private Node last;
    private int size;

    public CircularLinkedList() {
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

    public void addFirst(Item element) {
        Node temp = new Node(element, first, last);
        if(first == null) {
            first = temp;
            first.next = first;
            first.prev =first;
            last = first;
        }
        else {
            first.prev = temp;
            last.next = temp;
            first = temp;
        }
        size++;
    }

    public void addLast(Item element) {
        Node temp = new Node(element, first, last);
        if (last == null) {
            last = temp;
            last.next = last;
            last.prev = last;
            first = last;
        } else {
            last.next = temp;
            first.prev = temp;
            last = temp;
        }
        size++;
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
