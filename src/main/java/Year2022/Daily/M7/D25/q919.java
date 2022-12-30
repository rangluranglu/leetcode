package Year2022.Daily.M7.D25;

import java.util.ArrayDeque;
import java.util.Queue;

public class q919 {


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

class CBTInserter {
    Queue<TreeNode> father;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        father = new ArrayDeque<>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }

            if(node.left == null || node.right == null){
                father.offer(node);
            }
        }


    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode preNode = father.peek();

        if(preNode.left == null){
            preNode.left = newNode;
        }else{
            preNode.right = newNode;
            father.poll();
        }
        father.offer(newNode);

        return preNode.val;

    }

    public TreeNode get_root() {
        return root;
    }
}
