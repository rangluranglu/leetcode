package Year2023.Daily.M2.D3;

import Common.TreeNode;

public class q1145 {
    TreeNode xNode;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 计算x 为根的子树大小
        // 分为3个区域 x的左子树， 有字数， 其余节点  数 n -1
        dfs(root, x);
        int leftSize = getSubtreeSize(xNode.left);
        if(leftSize >= (n + 1) / 2){
            return true;
        }
        int rightSize = getSubtreeSize(xNode.right);
        if(rightSize >= (n + 1) / 2){
            return true;
        }

        int remain = n - 1 - leftSize - rightSize;
        return  remain >= (n + 1) / 2;
    }

    public void dfs(TreeNode node, int x){
        if(xNode != null || node == null){
            return;
        }

        if(node.val == x){
            xNode = node;
            return;
        }

        dfs(node.left, x);
        dfs(node.right, x);
    }

    public int getSubtreeSize(TreeNode node){
        if(node == null){
            return 0;
        }

        return 1 + getSubtreeSize(node.left) + getSubtreeSize(node.right);
    }
}
