package question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class q39 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 背包问题
        //  长度 <= 30， 可以回溯


        int n = candidates.length;

        dfs(candidates, 0, target, 0, new ArrayDeque<Integer>());
        return ans;
    }


    public void dfs(int[] candidates, int index, int target, int now, Deque<Integer> path){
        // 结束条件

        if(now > target || index >= candidates.length){
            return;
        }

        if(now == target){
            ans.add(new ArrayList<>(path));
            return;
        }

        dfs(candidates, index + 1, target, now, path);

        path.addLast(candidates[index]);
        dfs(candidates, index, target, now + candidates[index], path);
        path.removeLast();
    }
}
