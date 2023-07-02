package Year2023.Week.atemplate;

import java.util.Arrays;

public class q4 {
    public int sumImbalanceNumbers(int[] nums) {
        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);

            vis[nums[i]] = true;
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                int x = nums[j];

                if(!vis[x]){
                    cnt ++;
                    if(vis[x - 1]) cnt --;
                    if(vis[x + 1]) cnt --;

                    vis[x] = true;
                }
                ans += cnt;
            }
        }

        return ans;

    }

}
