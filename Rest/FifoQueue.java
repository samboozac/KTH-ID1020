/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description: Modified example from Robert Sedgewick's and Kevin Wayne's book, Algorithms: https://algs4.cs.princeton.edu/code/
***/
import java.util.NoSuchElementException;
public class FifoQueue<Item> {                                      /*Generic ADT, accepts any wrapper class*/
    private Node first;                                             /*Member variables or 'Instance variables' */
    private Node last;                                              /**/
    private int size;                                               /**/

    public FifoQueue() {                                            /*Constructor*/
        size = 0;                                                   /*Sets the original size to 0.*/
    }

    private class Node {                                            /*Inner class or 'helper class' */
        Item element;                                               /*Member variables or 'instance variables' */
        Node next;                                                  /**/
        Node prev;                                                  /**/

        public Node (Item element, Node next, Node prev) {          /*Constructor inner class*/
            this.element = element;                                 /*Member variables or 'Instance variables*/
            this.next = next;                                       /**/
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
        }

        public Item next() {
            Item element = current.element;
            current = current.next;
            return element;
        }
    }

    public int size () {                                            /*returns the size of the List*/
        return size;
    }

    public boolean isEmpty() {                                      /*Checks if the List is empty*/
        return size == 0;
    }

    public void enQueue(Item element) {
        Node temp = new Node(element, first, null);            /*next element is first, has no prev (null)*/
        if (first != null) {first.prev = temp;}                     /*If first exists it's prev must be the new temp*/
        first = temp;                                               /*Always set the new node to be the first one*/
        if (last == null) {last = temp;}                            /*If list empty, set new node to first AND last*/
        size++;                                                     /*Increment the size when adding a new Node*/
        System.out.println("Added: "+element);                      /*Confirmation on the Enqueue*/
    }

    public void deQueue() {
        if (size == 0) throw new NoSuchElementException();
        Node temp = last;
        last = last.prev;
        last.next = null;
        size--;
        System.out.println("Deleted: "+temp.element);
    }

    public void printString() {
        Node temp = first;
        while(temp != null) {
            System.out.print("|" + temp.element + "|");
            temp = temp.next;
        }
    }
}
