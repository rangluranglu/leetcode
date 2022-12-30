package Year2022.Daily.M9.D5;

import Common.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class q652 {
    Map<String, TreeNode> seen = new HashMap<String, TreeNode>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // 序列化
        // 时间复杂度：O(n2), 空间复杂度O(n2)
        dfs(root);
        return new ArrayList<>(repeat);
    }

    public String dfs(TreeNode node){
        if(node == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");

        String serial = sb.toString();
        if(seen.containsKey(serial)){
            repeat.add(seen.get(serial));
        }else {
            seen.put(serial, node);
        }
        return serial;
    }

    Map<String, Pair<TreeNode, Integer>> seen2 = new HashMap<>();
    Set<TreeNode> repeat2 = new HashSet<>();
    int idx = 0;
    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        // 使用三元数组直接表示 （x,l,r）
        // 分别表示 根节点的值，左子树的序号，右子树的序号

        dfs2(root);
        return new ArrayList<>(repeat2);
    }

    private int dfs2(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] tri = {root.val, dfs2(root.left), dfs2(root.right)};
        String hash = Arrays.toString(tri);
        if(seen2.containsKey(hash)){
            Pair<TreeNode, Integer> pair = seen2.get(hash);
            repeat2.add(pair.getKey());
            return pair.getValue();
        }else{
            seen2.put(hash, new Pair<TreeNode, Integer>(root, ++idx));
            return idx;
        }
    }


}
