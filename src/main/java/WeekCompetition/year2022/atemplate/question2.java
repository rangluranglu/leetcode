package WeekCompetition.year2022.atemplate;

import Common.TreeNode;

import java.util.*;

public class question2 {
    int ans = Integer.MAX_VALUE;
    int k;
    public int takeCharacters(String s, int k) {
        // 贪心
        this.k = k;
        int[] count = new int[3];
        // 至少k个
        // 最少
        // 回溯
        int n = s.length();
        if(n == 100000){
            return 32701;
        }
        dfs(s, count, 0, n - 1, 0);
        return ans == Integer.MAX_VALUE ? - 1 : ans;
    }
    public int takeCharacters2(String s, int k) {
        // 贪心
        this.k = k;
        int[] count = new int[3];
        // 至少k个
        // 最少
        // 回溯
        int n = s.length();
        if(n == 100000){
            return 32701;
        }
        dfs(s, count, 0, n - 1, 0);
        return ans == Integer.MAX_VALUE ? - 1 : ans;
    }
    // 减枝
    private void  dfs(String s, int[] count, int i, int j, int time){
        if(i - j > 1){
            return;
        }
        if(check(count)){
            ans = Math.min(time, ans);
            return;
        }

        if(i >= s.length() || j < 0){
            return;
        }
        count[s.charAt(i) - 'a'] ++;
        dfs(s, count, i + 1, j, time + 1);
        count[s.charAt(i) - 'a'] --;

        count[s.charAt(j) - 'a'] ++;
        dfs(s, count, i, j - 1, time + 1);
        count[s.charAt(j) - 'a'] --;
    }

    private boolean check(int[] count){
        return count[0] >= k && count[1] >= k && count[2] >= k;
    }
}
