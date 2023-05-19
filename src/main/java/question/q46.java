package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q46 {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        // 全排列, 不重复，dfs

        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int num : nums) {
            path.add(num);
        }
        dfs(0, nums.length, nums, path);
        return ans;
    }


    private void dfs(int cur, int n, int[] nums, List<Integer> path){
        if(cur == n){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = cur; i < n; i++){
            Collections.swap(path, cur, i);
            dfs(cur + 1, n, nums, path);
            Collections.swap(path,cur, i);
        }

    }
}
