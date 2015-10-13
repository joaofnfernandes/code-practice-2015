package delete_node;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestDeleteNode {
    
    @Test
    public void testDeleteEmptyList(){
        ListNode list = null;
        new Solution().deleteNode(list);
        assertEquals(null, list);
    }
    
    @Test
    public void testDeleteListHead(){
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        new Solution().deleteNode(list);
        assertEquals(1, list.val);
        assertEquals(null, list.next);
        
    }

}
