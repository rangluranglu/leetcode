package Year2023.Daily.M5.D22;

import Common.TreeNode;

public class q1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        // 不足节点
        // 通过节点node的每种可能的（根-叶） 路径上的值全都小于给定的limit

        // dfs 计算节点的最大和, 自底向下

        boolean haveSufficient = dfs(root,limit, 0);

        return haveSufficient ? root : null;
    }


    // node 节点为子树是否含有叶子节点不为「不足节点」
    private boolean dfs(TreeNode node, int limit, int sum){
        if(node == null ){
            return false;
        }

        // 提前处理
        if(node.left == null && node.right == null){
            return node.val + sum >= limit;
        }

        boolean left = dfs(node.left, limit, sum + node.val);
        boolean right = dfs(node.right, limit, sum + node.val);

        // Max 有负数
        if(!left){
            node.left = null;
        }

        if(!right){
            node.right = null;
        }
        return left || right;
    }
}
