package Year2022.Daily.M7.D31;


import java.util.LinkedList;
import java.util.Queue;

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

public class q1161 {
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int level = 0;
        int sum = Integer.MIN_VALUE;
        int ans = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;
            level ++;
            while(size -- > 0){
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            if(levelSum > sum){
                sum = levelSum;
                ans = level;
            }
        }

        return ans;
    }
}
