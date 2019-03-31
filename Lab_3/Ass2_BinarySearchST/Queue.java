package Ass2_BinarySearchST;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: Sam Florin
 * Created: 2018-09-26
 * Description: FIFO Queue API
 *  queue.enqueue(1) queue.enqueue(2) queue.enqueue(3)
 *  [1, 2, 3]
 *  queue.dequeue()
 *  [2, 3]
 */

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    // Helper class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    // Constructor, Initialize an empty Queue
    public Queue() {
        first = null;
        last  = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        Node<Item> temp = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            temp.next = last;
        size++;
    }

    public void dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue empty, can't dequeue!");
        first = first.next;
        size--;
        if (isEmpty())
            last = null;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        public ListIterator(Node<Item> first) {
            current = first;
        }
        public void delete(){}
        public boolean hasNext()  { return current != null;}
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Item item : this) {
            sb.append(item);
            if(item != last.item) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}