package WeekCompetition.year2022.W320;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class q2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // 中序遍历
        List<List<Integer>> ans = new ArrayList<>();
        int n = queries.size();
        for (int i = 0; i < n; i++) {
            // 搜索， 二分
            ans.add(find(root, queries.get(i)));
        }

        return ans;
    }

    private List<Integer> find(TreeNode root, int tar) {
        int left = -1;
        int right = -1;

        while(root != null){
            if(tar > root.val){
                left = root.val;
                root = root.right;
            }else if(tar < root.val){
                right = root.val;
                root = root.left;
            }else {
                return new ArrayList<Integer>(){{
                    add(tar);
                    add(tar);
                }};
            }
        }

        int finalLeft = left;
        int finalRight = right;
        return new ArrayList<Integer>(){{
            add(finalLeft);
            add(finalRight);
        }};
    }
}
