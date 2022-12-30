package Year2022.Week.W307;

import java.util.HashMap;
import java.util.Map;

public class q2384 {
    Map<Integer, TreeNode> parents = new HashMap<>();
    int ans = 0;
    TreeNode s = null;
    public int amountOfTime(TreeNode root, int start) {
        findParents(root, start);
        findMax(s, null, 0);
        return ans;
    }

    private void findMax(TreeNode node, TreeNode from, int depth) {
        if(node == null){
            return;
        }
        if(depth > ans){
            ans = depth;
        }

        if(node.left != from){
            findMax(node.left, node, depth + 1);
        }
        if(node.right != from){
            findMax(node.right, node, depth + 1);
        }
        if(parents.get(node.val) != from){
            findMax(parents.get(node.val), node, depth + 1);
        }
    }

    private void findParents(TreeNode root, int start) {
        if(root.val == start){
            s = root;
        }
        if(root.left != null){
            parents.put(root.left.val, root);
            findParents(root.left, start);
        }

        if(root.right != null){
            parents.put(root.right.val, root);
            findParents(root.right, start);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}