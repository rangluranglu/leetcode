package Year2022.Daily.M9.D10;

import Common.TreeNode;

public class q669 {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            // 递归
            if(root == null){
                return null;
            }

            if(root.val < low){
                return trimBST(root.right, low, high);
            }else if(root.val > high){
                return trimBST(root.left, low, high);
            }else {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            }
        }
}
