package question;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class q1028 {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> path = new ArrayDeque<>();
        int pos = 0;
        int n = traversal.length();

        while(pos < n){
            int level = 0;
            while(traversal.charAt(pos) == '-'){
                level ++;
                pos ++;
            }

            int val = 0;
            while(pos < n && Character.isDigit(traversal.charAt(pos))){
                val = val * 10 + (traversal.charAt(pos) - '0');
                pos ++;
            }

            TreeNode node = new TreeNode(val);

            // 下一层
            if(level == path.size()){
                if(!path.isEmpty()){
                    path.peek().left = node;
                }
            }else {
                while(level != path.size()){
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1){
            path.pop();
        }

        return path.peek();
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
