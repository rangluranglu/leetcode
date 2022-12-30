package Year2022.Week.W311;

import Common.TreeNode;

public class q2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        // 同时遍历左右子树
        dfs(root.left, root.right, 1);

        return root;
    }

    private void dfs(TreeNode l, TreeNode r, int depth){
        if(l == null){
            return;
        }

        if(depth % 2 == 1){
            int tmp = l.val;
            l.val = r.val;
            r.val = tmp;
        }

        dfs(l.left, r.right,depth + 1);
        dfs(l.right, r.left, depth + 1);
    }
}
