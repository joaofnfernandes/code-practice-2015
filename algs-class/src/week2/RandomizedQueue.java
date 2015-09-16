package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/*
 * Corner cases. The order of two or more iterators to the same randomized queue must be mutually independent;
 * each iterator must maintain its own random order.
 * 
 * Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * throw a java.util.NoSuchElementException if the client attempts to sample or
 *      dequeue an item from an empty randomized queue;
 * throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method
 *      in the iterator and there are no more items to return.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final double INCREASE_CAPACITY_THRESHOLD = 1;
    private static final double INCREASE_CAPACITY_RATIO = 2;
    private static final double DECREASE_CAPACITY_THRESHOLD = 0.25;
    private static final double DECREASE_CAPACITY_RATIO = 0.5;
    private static final int INITIAL_CAPACITY = 10;

    private Item[] items;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[INITIAL_CAPACITY];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException(
                    "Can't add nulls to a Randomized Queue");
        }
        increaseArrayIfNeeded();
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(size);
        swap(items, random, size - 1);
        // avoid loitering
        Item item = items[size - 1];
        items[size - 1] = null;
        size--;
        decreaseArrayIfNeeded();
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(size);
        return items[random];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] items;
        private int size = RandomizedQueue.this.size;

        private RandomizedQueueIterator() {
            if (size > 0) {
                items = (Item[]) new Object[size];
                for (int i = 0; i < items.length; i++) {
                    items[i] = RandomizedQueue.this.items[i];
                }
            }
        }

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Item next() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            int random = StdRandom.uniform(size);
            swap(items, random, size - 1);
            return items[--size];

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void increaseArrayIfNeeded() {
        if (size == items.length * INCREASE_CAPACITY_THRESHOLD) {
            Item[] aux = (Item[]) new Object[(int) (items.length * INCREASE_CAPACITY_RATIO)];
            for (int i = 0; i < size; i++) {
                aux[i] = items[i];
            }
            items = aux;
        }
    }

    private void decreaseArrayIfNeeded() {
        if (size == items.length * DECREASE_CAPACITY_THRESHOLD) {
            Item[] aux = (Item[]) new Object[(int) (items.length * DECREASE_CAPACITY_RATIO)];
            for (int i = 0; i < size; i++) {
                aux[i] = items[i];
            }
            items = aux;
        }
    }

    private void swap(Item[] arr, int i, int j) {
        Item aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
