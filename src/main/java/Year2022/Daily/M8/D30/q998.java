package Year2022.Daily.M8.D30;

import Common.TreeNode;

public class q998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        // root是一个数组生成的最大二叉树
        // 如果根节点的值小于给定的整数val，那么新的树会以val 作为根节点，并将原来的树作为新的根节点的左子树。
        //  当我们遍历到节点cur 以及它的父节点parent，并且cur 节点的值小于val 时，我们就可以停止遍历，构造一个新的节点，以val 为值且以 cur 为左子树。我们将该节点作为 parent 的新的右节点，并返回根节点作为答案即可。
        // 如果遍历完成之后，仍然没有找到比 val 值小的节点，那么我们构造一个新的节点，以 val 为值，将该节点作为parent 的右节点，并返回根节点作为答案即可。
        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null){
            if(val > curr.val){
                // 找到第一个小于的节点
                if(parent == null){
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, curr, null);
                parent.right = node;
                return root;
            }else{
                parent = curr;
                curr = curr.right;
            }
        }

        parent.right = new TreeNode(val);
        return root;
    }
}
