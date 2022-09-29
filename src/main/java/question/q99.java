package question;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class q99 {
    public void recoverTree(TreeNode root) {
        // 二叉搜索树的两个节点被错误的交换， 中序遍历是递增的
        // i < j 且 ai > a i+1 && a aj > a j + 1， ai 和 a j+1
        // 中序遍历 左 -> 中 -> 右

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null, a = null, b = null;

        while (!stack.isEmpty() || root != null){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(pre != null && root.val < pre.val){
                b = root;
                if(a == null){
                    a = pre;
                }else {
                    break;
                }
            }

            pre = root;
            root = root.right;
        }

        swap(a, b);
    }

    public void swap(TreeNode x, TreeNode y){
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }


    public void recoverTree2(TreeNode root) {
        // 二叉搜索树的两个节点被错误的交换， 中序遍历是递增的

    }

    public void recoverTree3(TreeNode root) {
        // 二叉搜索树的两个节点被错误的交换， 中序遍历是递增的

    }
}
