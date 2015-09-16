package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TestDeque {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void TestAddFirstEmptyDeque() {
        int N = 1;
        
        Deque<Integer> d = new Deque<Integer>();
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
        
        d.addFirst(N);
        assertEquals(1, d.size());
        assertFalse(d.isEmpty());
    }
    
    @Test
    public void testAddLastEmptyDeque() {
        int N = 1;
        
        Deque<Integer> d = new Deque<Integer>();
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
        
        d.addLast(N);
        assertEquals(1, d.size());
        assertFalse(d.isEmpty());
    }
    
    @Test
    public void testAddFirst1Deque() {
        Deque<Integer> d = new Deque<Integer>();
        
        d.addFirst(2);
        d.addFirst(1);
        assertEquals(2, d.size());
        assertFalse(d.isEmpty());
    }
    
    @Test
    public void testAddLast1Deque() {
        Deque<Integer> d = new Deque<Integer>();
        
        d.addLast(1);
        d.addLast(2);
        assertEquals(2, d.size());
        assertFalse(d.isEmpty());
    }
    
    @Test
    public void testAddNullToFirst(){
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        exception.expect(NullPointerException.class);
        d.addFirst(null);
    }
    
    @Test
    public void testAddNullToLast(){
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        exception.expect(NullPointerException.class);
        d.addLast(null);
    }
    
    @Test
    public void restRemoveFirstEmptyDeque(){
        Deque<Integer> d = new Deque<Integer>();
        exception.expect(NoSuchElementException.class);
        d.removeFirst();
    }
    
    @Test
    public void testRemoveLastEmptyDeque(){
        Deque<Integer> d = new Deque<Integer>();
        exception.expect(NoSuchElementException.class);
        d.removeLast();
    }
    
    @Test
    public void testRemoveFirst1Deque(){
        int N = 1;
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(N);
        assertEquals(N, (int)d.removeFirst());
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
    }
    
    @Test
    public void testRemoveLast1Deque(){
        int N = 1;
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(N);
        assertEquals(N, (int)d.removeLast());
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
}
    
    @Test
    public void testRemoveFirstNDeque(){
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(2); d.addFirst(1);
        assertEquals(1, (int)d.removeFirst());
        assertEquals(1, d.size());
        assertFalse(d.isEmpty());
    }
    
    @Test
    public void testRemoveLastNDeque(){
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(2); d.addFirst(1);
        assertEquals(2, (int)d.removeLast());
        assertEquals(1, d.size());
        assertFalse(d.isEmpty());
    }
    
    @Test
    public void testIterateEmtpyDeque(){
        Deque<Integer> d = new Deque<Integer>();
        Iterator<Integer> iter = d.iterator();
        assertFalse(iter.hasNext());
        exception.expect(NoSuchElementException.class);
        iter.next();
    }
    
    @Test
    public void testIterateNDeque(){
        int[] N = new int[] {1,2,3,4,5,6,7};
        Deque<Integer> d = new Deque<>();
        for (int i = 0; i < N.length; i++) {
            d.addLast(N[i]);
        }
        Iterator<Integer> iter = d.iterator();
        for (int i = 0; i < N.length; i++) {
            assertEquals(N[i], (int)iter.next());
        }
    }

    @Test
    public void testRemoveFromIterator() {
        Deque<Integer> d = new Deque<Integer>();
        d.addFirst(1);
        Iterator<Integer> iter = d.iterator();
        exception.expect(UnsupportedOperationException.class);
        iter.remove();
    }
}
