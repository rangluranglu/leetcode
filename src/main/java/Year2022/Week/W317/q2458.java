package Year2022.Week.W317;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class q2458 {
    private Map<TreeNode, Integer> height = new HashMap<>();
    private int[] res;

    public int[] treeQueries(TreeNode root, int[] queries) {
        getHigh(root);

        height.put(null, 0); // 简化dfs代码， 这样不用写getOrDefault

        res = new int[height.size()];

        dfs(root, -1, 0);
        for(int i = 0; i < queries.length; i++){
            queries[i]=res[queries[i]];
        }

        return queries;
    }

    private void dfs(TreeNode node, int depth, int restH) {
        if(node == null){
            return;
        }
        depth ++;
        res[node.val] = restH;
        dfs(node.left, depth, Math.max(restH, depth + height.get(node.right)));
        dfs(node.right, depth, Math.max(restH, depth +height.get(node.left)));

    }

    private int getHigh(TreeNode root) {

        if(root == null){
            return 0;
        }

        int h = 1 + Math.max(getHigh(root.left), getHigh(root.right));
        height.put(root, h);

        return h;
    }
}
