package Year2023.Week.DW102;

import Common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class q2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        // 每个节点替换成堂兄弟节点的和
        // 相同深度，不同父节点
        // 使用bfs 计算两次

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 遍历
            List<TreeNode> tmp = queue;

            queue = new ArrayList<>();
            int nextLevelSum = 0;
            for(TreeNode node : tmp){
                if(node.left != null){
                    queue.add(node.left);
                    nextLevelSum += node.left.val;
                }
                if(node.right != null){
                    queue.add(node.right);
                    nextLevelSum += node.right.val;
                }
            }

            // 再次遍历， 更新
            for(TreeNode node : tmp){
                int childSum = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
                if(node.left != null){
                    node.left.val = nextLevelSum - childSum;
                }
                if(node.right != null){
                    node.right.val = nextLevelSum - childSum;
                }
            }
        }

        root.val = 0;
        return root;
    }

}
