package Year2022.Daily.M8.D27;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class q662 {
    Map<Integer, Integer> levelMin = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        // bfs 简单
        // dfs 呢？
        return dfs(root, 1, 1);

    }


    public int dfs(TreeNode node, int depth, int index){
        if(node == null){
            return 0;
        }

        levelMin.putIfAbsent(depth, index);
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
