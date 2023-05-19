package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q47 {
    List<List<Integer>> ans;
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 全排列， 处理重复, 搜索回溯

        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        vis = new boolean[nums.length];
        ans = new ArrayList<>();

        dfs(nums, nums.length, 0, path);

        return ans;
    }

    private void dfs(int[] nums, int n, int cur, List<Integer> path){
        if(cur == n){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])){
                continue;
            }

            path.add(nums[i]);
            vis[i] = true;
            dfs(nums, n, cur + 1, path);
            vis[i] = false;
            path.remove(cur);
        }
    }
}
