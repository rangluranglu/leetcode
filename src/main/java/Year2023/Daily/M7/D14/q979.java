package Year2023.Daily.M7.D14;

import Common.TreeNode;

public class q979 {

    int ans = 0;
    public int distributeCoins(TreeNode root) {
        // 分配硬币
        // 同一颗子树，可以直接向上或向下移动，在不同子树时移动到公共父节点再向下移动
        // 公共祖先节点
        // 如何计算数量


        // 深度优先搜索

        dfs(root);
        return ans;

    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int moveLeft = 0;
        int moveRight = 0;

        if(node.left != null){
            moveLeft = dfs(node.left);
        }

        if(node.right != null){
            moveRight = dfs(node.right);
        }

        ans += Math.abs(moveRight) + Math.abs(moveLeft);

        return moveRight + moveLeft + node.val - 1;
    }
}
