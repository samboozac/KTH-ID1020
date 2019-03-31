/* Lab 2, Assignment 7 */

public class LinkedList {
    private Node first;                                             /*Member variables or 'Instance variables' */
    private int size;                                               /**/

    public LinkedList() {                                            /*Constructor*/
        size = 0;                                                   /*Sets the original size to 0.*/
    }

    private class Node {                                            /*Inner class or 'helper class' */
        int element;                                               /*Member variables or 'instance variables' */
        Node next;                                                  /**/

        public Node (int element, Node next) {                      /*Constructor inner class*/
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
            return current.next != null;
        }

        public void remove() {}

        public int next() {
            int element = current.element;
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

    public void add(int element) {
        Node temp = new Node(element, null);
        if(first == null || element <= first.element) {
            temp.next = first;
            first = temp;
        } else {
            Node current = first;
            while(current.next != null && current.next.element < temp.element) {
                current = current.next;
            }
            temp.next = current.next;
            current.next = temp;
        }
        size++;
    }

    public void printList() {
        StringBuilder sb = new StringBuilder(" ");
        sb.append("[");
        Node temp = first;
        while(temp.next != null) {
            sb.append(temp.element + ", ");
            temp = temp.next;
        }
        sb.append(temp.element);
        sb.append("]");
        StdOut.println(sb);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(-2);
        list.add(1);
        list.add(-1);
        list.add(4);
        list.printList();
    }
}
