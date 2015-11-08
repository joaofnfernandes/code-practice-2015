package easy.lowest_ancestor_bst;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCommonAncestor {

    @Test
    public void testEmptyTree() {
        TreeNode tree = null;
        assertEquals(null,
                new Solution().lowestCommonAncestor(tree, tree, tree));
    }

    @Test
    public void testParentAndLeftChild() {
        TreeNode tree = makeTree(new Integer[] { 0, 1, 0 });
        TreeNode left = new TreeNode(1);

        TreeNode result = new Solution().lowestCommonAncestor(tree, left, tree);
        assertTrue(isSameNode(tree, result));
    }

    @Test
    public void testParentAndRightChild() {
        TreeNode tree = makeTree(new Integer[] { 0, 1, null, 2 });
        TreeNode right = new TreeNode(2);

        TreeNode result = new Solution()
                .lowestCommonAncestor(tree, right, tree);
        assertTrue(isSameNode(tree, result));
    }

    @Test
    public void testParent() {
        TreeNode tree = makeTree(new Integer[] {0, 6, 2, 8, 0, 4, 7, 9, null,
                                                null, 3, 5 });

        TreeNode expected = new TreeNode(4);
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        

        TreeNode result = new Solution().lowestCommonAncestor(tree, p, q);
        assertTrue(String.format("Expected %d, got %d", expected.val, result.val),
                    isSameNode(expected, result));
    }

    @Test
    public void testGrandparent1() {
        TreeNode tree = makeTree(new Integer[] { 0, 3, 1, 5, null, 2, 4, null });

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        TreeNode result = new Solution().lowestCommonAncestor(tree, p, q);
        assertTrue(isSameNode(tree, result));
    }

    @Test
    public void testGrandparent2() {
        TreeNode tree = makeTree(new Integer[] { 0, 3, 1, 5, 0, null, null, 6 });

        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(6);

        TreeNode result = new Solution().lowestCommonAncestor(tree, p, q);
        assertTrue(isSameNode(tree, result));
    }

    private TreeNode makeTree(Integer[] values) {
        return makeTree(values, 1);
    }

    private TreeNode makeTree(Integer[] values, int i) {
        if (i >= values.length || values[i] == null) {
            return null;
        }
        TreeNode node = new TreeNode(values[i]);
        node.left = makeTree(values, i * 2);
        node.right = makeTree(values, i * 2 + 1);
        return node;
    }

    private boolean isSameNode(TreeNode n, TreeNode m) {
        if (n == null) {
            if (m == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (m == null) {
                return false;
            } else {
                return n.val == m.val;
            }
        }
    }
}
