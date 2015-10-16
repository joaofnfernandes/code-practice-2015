package bottom_up_level_traverse;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.List;

import org.junit.Test;

public class TestLevelOrderBottom {

    @Test
    public void testFullTree() {
        TreeNode tree = makeTree(new Integer[] { 1, 2, 2, 3, 3, 3, 3 });
        Integer[][] expected = { { 3, 3, 3, 3 }, { 2, 2 }, { 1 } };
        Solution sol = new Solution();
        List<List<Integer>> result1 = sol.levelOrderBottom(tree);
        List<List<Integer>> result2 = sol.levelOrderBottom2(tree);
        assertTrue(isSameList(expected, result1));
        assertTrue(isSameList(expected, result2));
    }

    @Test
    public void testLeftLeaningTree() {
        TreeNode tree = makeTree(new Integer[] { 1, 2, null, 3, null });
        Integer[][] expected = { { 3 }, { 2 }, { 1 } };
        Solution sol = new Solution();
        List<List<Integer>> result1 = sol.levelOrderBottom(tree);
        List<List<Integer>> result2 = sol.levelOrderBottom2(tree);
        assertTrue(isSameList(expected, result1));
        assertTrue(isSameList(expected, result2));
    }

    @Test
    public void testRightLeaningTree() {
        TreeNode tree = makeTree(new Integer[] { 1, null, 2, null, 3 });
        Integer[][] expected = { { 3 }, { 2 }, { 1 } };
        Solution sol = new Solution();
        List<List<Integer>> result1 = sol.levelOrderBottom(tree);
        List<List<Integer>> result2 = sol.levelOrderBottom2(tree);
        assertTrue(isSameList(expected, result1));
        assertTrue(isSameList(expected, result2));
    }

    @Test
    public void testUnbalancedTree() {
        TreeNode tree = makeTree(new Integer[] { 1, 2, 2, 3, null, null, 3,
                                                null, 4, 4, null });
        Integer[][] expected = { { 4, 4 }, { 3, 3 }, { 2, 2 }, { 1 } };
        Solution sol = new Solution();
        List<List<Integer>> result1 = sol.levelOrderBottom(tree);
        List<List<Integer>> result2 = sol.levelOrderBottom2(tree);
        assertTrue(isSameList(expected, result1));
        assertTrue(isSameList(expected, result2));
    }

    private boolean isSameList(Integer[][] arr, List<List<Integer>> list) {
        if (list.size() != arr.length) {
            return false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> l = list.get(i);
                if (l.size() != arr[i].length) {
                    return false;
                } else {
                    for (int j = 0; j < l.size(); j++) {
                        if (l.get(j) != arr[i][j]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    private TreeNode makeTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        int i = 0;
        TreeNode head = new TreeNode(values[i++]);
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(head);
        TreeNode node;
        while (i + 1 < values.length && !deque.isEmpty()) {
            node = deque.pop();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                deque.addLast(node.left);
            }
            i++;
            if (values[i] != null) {
                node.right = new TreeNode(values[i]);
                deque.addLast(node.right);
            }
            i++;
        }
        return head;
    }
}
