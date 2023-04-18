package Year2023.Daily.M4.D18;

import Common.TreeNode;

public class q1026 {
    public int maxAncestorDiff(TreeNode root) {
        // 深度优先
        return dfs(root, root.val, root.val);
    }


    public int dfs(TreeNode root, int mi, int ma){
        if(root == null){
            return 0;
        }

        int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        mi = Math.min(mi, root.val);
        ma = Math.max(ma, root.val);

        diff = Math.max(diff, dfs(root.left, mi, ma));
        diff = Math.max(diff, dfs(root.right, mi, ma));

        return diff;
    }
}
