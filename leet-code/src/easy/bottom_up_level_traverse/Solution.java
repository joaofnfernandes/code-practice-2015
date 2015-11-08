package easy.bottom_up_level_traverse;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class Solution {
    private TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null) {
            return list;
        }
        deque.add(root);
        while(!deque.isEmpty()) {
            List<Integer> elements = new ArrayList<>();
            int count = deque.size();
            for(int i = 0; i < count; i++) {
                TreeNode node = deque.pop();
                elements.add(node.val);
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
            }
            list.add(0, elements);
        }
        return list;
    }
    
    
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        levelOrderBottom(root, 0);
        List<List<Integer>> list =  new ArrayList<>();
        for (Integer value : map.descendingKeySet()) {
            list.add(map.get(value));
        }
        return list;
    }
    
    private void levelOrderBottom(TreeNode node, int depth) {
        if(node == null) {
            return;
        } else {
            addNode(node, depth);
            levelOrderBottom(node.left, depth + 1);
            levelOrderBottom(node.right, depth + 1);
        }
    }
    
    private void addNode(TreeNode node, int depth) {
        if(map.containsKey(depth)) {
            map.get(depth).add(node.val);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(depth, list);
        }
    }
}
