package Daily.year2022.M9.D2;

import Common.TreeNode;

public class q687 {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {

        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if(root.left != null && root.left.val == root.val){
            left1 = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            right1 = right + 1;
        }

        ans = Math.max(ans, left1 + right1);

        return Math.max(left1, right1);
    }


}
