package Year2023.Daily.M5.D30;

import Common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class q1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // 删点成林
        // dfs

        Set<Integer> set = new HashSet<>();

        for (int d : to_delete) {
            set.add(d);
        }

        List<TreeNode> ans = new ArrayList<>();

        // 根节点要删除怎么办
        dfs(root, set, ans, null);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }

    private void dfs(TreeNode node, Set<Integer> set, List<TreeNode> ans, TreeNode pre){
        if(node == null){
            return;
        }

        if(set.contains(node.val)){
            if(pre != null){
                if(pre.left == node) pre.left = null;
                if(pre.right == node) pre.right = null;
            }

            // 包含
            if(node.left != null && !set.contains(node.left.val)) ans.add(node.left);
            if(node.right != null && !set.contains(node.right.val)) ans.add(node.right);
        }

        dfs(node.left, set, ans, node);
        dfs(node.right, set, ans, node);
    }


    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        // 删点成林
        // dfs

        Set<Integer> set = new HashSet<>();

        for (int d : to_delete) {
            set.add(d);
        }

        List<TreeNode> ans = new ArrayList<>();

        // 根节点要删除怎么办
        dfs2(root, set, ans, true);
        return ans;
    }

    public TreeNode dfs2(TreeNode node, Set<Integer> set, List<TreeNode> ans, boolean isRoot){
        if(node == null){
            return null;
        }

        // 需要删除
        boolean deleted = set.contains(node.val);

        node.left = dfs2(node.left, set, ans, deleted);
        node.right = dfs2(node.right, set, ans, deleted);

        if(deleted){
            return null;
        }else{
            if(isRoot) ans.add(node);
            return node;
        }

    }
}
