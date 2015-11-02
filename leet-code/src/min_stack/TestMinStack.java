package min_stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMinStack {
    
    @Test
    public void testAddRemove() {
        int n = 1;
        MinStack stack = new MinStack();
        stack.push(n);
        assertEquals(n, stack.top());
        assertEquals(n, stack.getMin());
    }
    
    @Test public void testMin() {
        int min = 2;
        int[] values = {3,5,4,6,7,5,3,4,5};
        MinStack stack = new MinStack();
        for (int v : values) {
            stack.push(v);
        }
        stack.push(min);
        for (int v : values) {
            stack.push(v);
        }
        for (int i = 0; i < values.length; i++) {
            assertEquals(min, stack.getMin());
            stack.pop();
        }
    }

}
