package medium.populate_right_next_ptr;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            
            TreeLinkNode node = queue.remove();
            int count = queue.size();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            for (int i = 0; i < count; i++) {
                node.next = queue.remove();
                node = node.next;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
