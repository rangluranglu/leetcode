package question;

import java.util.Map;

public class q222 {
    int maxDepth, res;
    public int countNodes(TreeNode root) {
        maxDepth = 0;
        res = 0;
        dfs(root, 0);
        //System.out.println("dep" + maxDepth + "res" + res);
        return (int) (Math.pow(2, maxDepth) - 1 + res);
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null){
            return;
        }

        if(depth > maxDepth){
            res = 1;
            maxDepth = depth;
        }else if(depth == maxDepth){
            res ++;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }
}
