package Year2023.Daily.M8.D25;

import Common.TreeNode;

public class q1448 {
    public int goodNodes(TreeNode root) {
        // dfs 记录最大值

        return dfs(root, Integer.MIN_VALUE);

    }


    public int dfs(TreeNode root, int pathMax){
        if(root == null){
            return 0;
        }

        int res = 0;
        if(root.val >= pathMax){
            res ++;
            pathMax = root.val;
        }

        res += dfs(root.left, pathMax) + dfs(root.right, pathMax);
        return res;
    }
}
