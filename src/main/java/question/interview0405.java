package question;

public class interview0405 {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }
        // 左根右
        if(prev != null && prev.val >= root.val){
            return false;
        }

        prev = root;

        if(!isValidBST(root.right)){
            return false;
        }

        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        // 前序遍历
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode node, int left, int right){
        if(node == null){
            return true;
        }

        int x = node.val;
        return left < x && x < right && helper(node.left, left, x) && helper(node.right, x, right);
    }

    public boolean isValidBST3(TreeNode root) {
        // 后序遍历
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
