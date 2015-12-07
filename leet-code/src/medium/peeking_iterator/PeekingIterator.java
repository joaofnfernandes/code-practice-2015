package medium.peeking_iterator;

import java.util.Iterator;

// an iterator that can peek the next element
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iter;
    Integer next;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(next == null) {
            if(iter.hasNext()) {
                next = iter.next();
            }
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(next != null) {
            Integer tmp = next;
            next = null;
            return tmp;
        } else {
            return iter.next();
        }
    }

    @Override
    public boolean hasNext() {
        return next != null || iter.hasNext();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}