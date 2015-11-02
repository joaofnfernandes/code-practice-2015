package tree_paths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePaths(root, "", new ArrayList<String>());
    }
    
    private List<String> binaryTreePaths(TreeNode node, String pathSoFar, List<String> paths) {
        if(node == null) {
            return paths;
        } else if (node.left == null && node.right == null) {
            pathSoFar = String.format("%s%d", pathSoFar, node.val);
            paths.add(pathSoFar);
            return paths;
        } else {
            pathSoFar = String.format("%s%d->", pathSoFar, node.val);
            binaryTreePaths(node.left, pathSoFar, paths);
            binaryTreePaths(node.right, pathSoFar, paths);
            return paths;
        }
    }
}