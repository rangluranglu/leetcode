package Year2023.Daily.M2.D6;

import Common.TreeNode;

public class q2331 {
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null){
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val == 2 ? left || right : right && left;
    }
}
