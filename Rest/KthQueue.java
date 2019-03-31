/***
* Creator: Sam Florin
* Date: 2018-09-10
* Description: Modified example from Robert Sedgewick's and Kevin Wayne's book, Algorithms: https://algs4.cs.princeton.edu/code/
***/
import java.util.NoSuchElementException;

public class KthQueue<Item> {
    private Node first;
    private Node last;
    private int size;

    public KthQueue() {
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
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void addFirst(Item element) {
        Node tmp = new Node(element, first, null);
        if(first != null ) {
            first.prev = tmp;}
        first = tmp;
        if(last == null) { last = tmp;}
        size++;
        System.out.println("adding: "+element);
    }

    public void addLast(Item element) {

        Node tmp = new Node(element, null, last);
        if(last != null) {
            last.next = tmp;}
        last = tmp;
        if(first == null) { first = tmp;}
        size++;
        System.out.println("adding: "+element);
    }

    public void iterateForward(){

        System.out.println("iterating forward..");
        Node tmp = first;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public void iterateBackward(){

        System.out.println("iterating backword..");
        Node tmp = last;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = first;
        first = first.next;
        first.prev = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }

    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = last;
        last = last.prev;
        last.next = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }

    public void removeKTH(int k) {
        Node temp = first;
        Node temp2;
        while (k > 1){
            temp = temp.next;
            k--;
        }
            temp2 = temp.prev;          /*Store*/
            temp2.next = temp.next;     /*Points through the KTH-element*/
            temp = temp2.next;          /*Store*/
            temp.prev = temp2;          /*Points through the KTH-element backwards*/
    }


}
