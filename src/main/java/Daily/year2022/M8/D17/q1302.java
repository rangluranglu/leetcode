package Daily.year2022.M8.D17;


public class q1302 {
    int ans = 0;
    int maxLevel = - 1;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }

        if(level > maxLevel){
            maxLevel = level;
            ans = root.val;
        }else if(level == maxLevel){
            ans += root.val;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}