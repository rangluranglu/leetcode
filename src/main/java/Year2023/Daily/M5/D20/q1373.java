package Year2023.Daily.M5.D20;

import Common.TreeNode;

public class q1373 {
    private int ans;
    public int maxSumBST(TreeNode root) {
        dfs(root);

        return ans;
    }

    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int x = node.val;

        if(x <= left[1] || x >= right[0]){
            // 不是二叉搜索树
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }

        int s = left[2] + right[2] + x;

        ans = Math.max(ans, s);

        // [最小节点值， 最大节点值， 和]
        return new int[]{Math.min(left[0], x), Math.max(right[1], x), s};
    }
}
