package Year2022.Daily.M8.D5;

import java.util.ArrayList;
import java.util.List;

public class q623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // bfs
        if(root == null){
            return null;
        }
        if(depth == 1){
            return new TreeNode(val, root, null);
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        for(int i = 1; i < depth - 1; i++){
            List<TreeNode> curLevel = new ArrayList<>();
            for(TreeNode node : list){
                if(node.left != null){
                    curLevel.add(node.left);
                }
                if(node.right != null){
                    curLevel.add(node.right);
                }

                list = curLevel;
            }
        }

        for(TreeNode node : list){
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }

        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
