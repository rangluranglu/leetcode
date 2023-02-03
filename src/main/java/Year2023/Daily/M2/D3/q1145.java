package Year2023.Daily.M2.D3;

import Common.TreeNode;

public class q1145 {
    int count = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 计算x 为根的子树大小
        // 分为3个区域 x的左子树， 有字数， 其余节点  数 n -1
        if(root.val == x){
            dfs(root, root.left.val, false);
            return count != n- 1 -count;
        }
        dfs(root, x, false);
        System.out.println(count);
        return count < n - count;
    }

    public void dfs(TreeNode node, int x, boolean isRoot){
        if(node == null){
            return;
        }
        if(node.val == x){
            isRoot = true;
        }

        dfs(node.left, x, isRoot);
        dfs(node.right, x, isRoot);

        if(isRoot){
            count++;
        }
    }
}
