package question;

import java.util.HashMap;
import java.util.Map;


public class q105 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序 中 左 右
        // 中序 左 中 右
        map = new HashMap<>();
        int n = preorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int rootIndex = map.get(root.val);

        root.left = dfs(preorder, inorder, pl + 1, pl + rootIndex - il, il, rootIndex - 1);
        root.right = dfs(preorder, inorder, pl + rootIndex - il + 1, pr, rootIndex + 1, ir);

        return root;

    }


}
