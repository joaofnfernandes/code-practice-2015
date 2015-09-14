package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Corner cases.
 * Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque;
 * throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there
 *  are no more items to return.

 Performance requirements.
 Your deque implementation must support each deque operation in constant worst-case time.
 A deque containing N items must use at most 48N + 192 bytes of memory.
 and use space proportional to the number of items currently in the deque.
 Additionally, your iterator implementation must support each operation (including construction)
 in constant worst-case time.
 */

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size = 0;

    private class Node {
        private Item value;
        private Node next;
        private Node previous;

        private Node(Item value) {
            this.value = value;
        }
    }

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException("Can't add nulls to deque");
        }
        Node n = new Node(item);
        n.next = first;
        if (first == null) {
            first = n;
            last = n;
        } else {
            first.previous = n;
            first = n;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException("Can't add nulls to deque");
        }
        Node n = new Node(item);
        n.previous = last;
        if (last == null) {
            last = n;
            first = n;
        } else {
            last.next = n;
            last = n;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item item;
        if (first == null) {
            throw new NoSuchElementException(
                    "Can't remove items from an empty deque");
        } else if (first == last) {
            item = first.value;
            first = null;
            last = null;
        } else {
            item = first.value;
            first = first.next;
            first.previous = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        Item item;
        if (last == null) {
            throw new NoSuchElementException(
                    "Can't remove items from an empty deque");
        } else if (first == last) {
            item = first.value;
            first = null;
            last = null;
        } else {
            item = last.value;
            last = last.previous;
            last.next = null;
        }
        size--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node next = Deque.this.first;

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Item next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            Item value = next.value;
            next = next.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing
    public static void main(String[] args) {
    }
}
