package Year2022.Daily.M8.D20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        // 降序
        Deque<Integer> stack = new ArrayDeque<>();

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        TreeNode[] tree = new TreeNode[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new TreeNode(nums[i]);

            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                right[stack.pop()] = i;
            }

            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if(left[i] == -1 && right[i] == -1){
                root = tree[i];
            }else if(right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])){
                tree[left[i]].right = tree[i];
            }else{
                tree[right[i]].left = tree[i];
            }
        }

        return root;
    }
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