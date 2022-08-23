package Daily.year2022.M8.D22;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class q655 {
    public List<List<String>> printTree(TreeNode root) {
        // 高度和宽度
        // 高度
        int height = findHeight(root);

        int m = height + 1;
        int n = ( 1 << (m)) - 1;

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }

            ans.add(row);
        }

        dfs(ans, root, 0, (n - 1) / 2, height);

        return ans;

    }

    private void dfs(List<List<String>> ans, TreeNode root, int r, int c, int height) {
        ans.get(r).set(c, Integer.toString(root.val));

        if(root.left != null){
            dfs(ans, root.left, r + 1,  c - (1 << (height - r - 1)), height);
        }

        if(root.right != null){
            dfs(ans, root.right, r + 1, c + (1 << (height - r - 1)), height);
        }


    }

    private int findHeight(TreeNode root) {
        if(root.left == null && root.right == null){
            return 0;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }


}
