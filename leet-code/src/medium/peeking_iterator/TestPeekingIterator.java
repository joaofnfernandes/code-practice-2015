package medium.peeking_iterator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestPeekingIterator {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    
    @Test
    public void testGetNextOnEmptyIterator() {
        List<Integer> list = Arrays.asList(new Integer[] {});
        PeekingIterator iter = new PeekingIterator(list.iterator());
        thrown.expect(NoSuchElementException.class);
        iter.next();
    }
    
    @Test
    public void testHasNextOnEmptyIterator() {
        List<Integer> list = Arrays.asList(new Integer[] {});
        PeekingIterator iter = new PeekingIterator(list.iterator());
        assertFalse(iter.hasNext());
    }
    
    @Test
    public void testPeekOnEmptyIterator() {
        List<Integer> list = Arrays.asList(new Integer[] {});
        PeekingIterator iter = new PeekingIterator(list.iterator());
        assertNull(iter.peek());
    }
    
    @Test
    public void testPeekPeekNext() {
        List<Integer> list = Arrays.asList(new Integer[] {1,2,3,4,5});
        PeekingIterator iter = new PeekingIterator(list.iterator());
        final Integer expected = 1;
        final int n = 5;
        for (int i = 0; i < n; i++) {
            assertEquals(expected, iter.peek());
        }
        assertEquals(expected, iter.next());
        assertNotEquals(expected, iter.next());
    }
    
    @Test
    public void testNextPeek() {
        Integer[] elements = new Integer[] {1,2,3,4,5};
        List<Integer> list = Arrays.asList(elements);
        PeekingIterator iter = new PeekingIterator(list.iterator());
        for (int i = 0; i < elements.length; i++) {
            iter.peek();
            assertEquals(elements[i], iter.next());
            iter.peek();
        }
    }
    
    
}
