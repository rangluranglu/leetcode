package question;

public class q1123 {
    int pre = 0;
    TreeNode ans = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // dfs 深度最深
        dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);

        if(left == right && left > pre){
            pre = left;
            ans = root;
        }

        return Math.max(left, right);
    }
}
