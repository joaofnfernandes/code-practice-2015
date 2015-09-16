package week2;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

// todo: test that numbers are picked in uniform distribution
public class TestRandomizedQueue {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testDequeueEmptyDeque(){
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        assertEquals(0, rq.size());
        assertTrue(rq.isEmpty());
        exception.expect(NoSuchElementException.class);
        rq.dequeue();
    }

    @Test
    public void testSampleEmptyDeque(){
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        assertEquals(0, rq.size());
        assertTrue(rq.isEmpty());
        exception.expect(NoSuchElementException.class);
        rq.sample();
    }
    
    @Test
    public void testIterateEmptyDeque(){
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        assertEquals(0, rq.size());
        assertTrue(rq.isEmpty());
        Iterator<Integer> iter = rq.iterator();
        assertFalse(iter.hasNext());
        exception.expect(NoSuchElementException.class);
        iter.next();
    }
    
    @Test
    public void testDequeue1Deque(){
        int N = 1;
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(N);
        
        assertEquals(1, rq.size());
        assertFalse(rq.isEmpty());
        
        assertEquals(N, (int)rq.dequeue());
        assertEquals(0, rq.size());
        assertTrue(rq.isEmpty());
    }

    @Test
    public void testSample1Deque(){
        int N = 1;
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(N);
        
        assertEquals(1, rq.size());
        assertFalse(rq.isEmpty());
        
        assertEquals(N, (int)rq.sample());
        assertEquals(1, rq.size());
        assertFalse(rq.isEmpty());
    }
    
    @Test
    public void testIterate1Deque(){
        int N = 1;
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(N);
        Iterator<Integer> iter = rq.iterator();
        // Use iterator until the end
        assertTrue(iter.hasNext());
        assertEquals(N, (int)iter.next());
        assertFalse(iter.hasNext());
        // Queue is still the same
        assertFalse(rq.isEmpty());
    }

    @Test
    public void testAddEmptyAdd() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        assertTrue(rq.isEmpty());
        
        rq.enqueue(1);
        assertFalse(rq.isEmpty());
        
        rq.dequeue();
        assertTrue(rq.isEmpty());
        
        rq.enqueue(1);
        assertFalse(rq.isEmpty());
    }
    
    @Test
    public void testIteratorsAreIndependent() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        Iterator<Integer> emptyIter = rq.iterator();
        emptyIter.next();
        Iterator<Integer> iter = rq.iterator();
        
        assertFalse(emptyIter.hasNext());
        assertTrue(iter.hasNext());
    }
}
