package Year2023.Week.W340;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2615 {
    public long[] distance(int[] nums) {
        // 分组
        // num 为0的 下标为 0， 2， 3  --> 和为 5

        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // 计算和
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[n];
        long[] s = new long[n + 1];

        for (List<Integer> value : map.values()) {
            int m = value.size();

            // 前缀和
            for (int i = 0; i < m; i++) {
                s[i + 1] = s[i] + value.get(i);
            }

            for (int i = 0; i < m; i++) {
                int target = value.get(i);
                // 左边的和  s[i] = 前i个， 不包括i
                long left = (long) target * i - s[i];
                long right = s[m] - s[i + 1] - (long) target * (m - i - 1);
                ans[target] = left + right;
            }
        }

        return ans;
    }


    public long[] distance2(int[] nums) {
        // 分组
        // 考虑增量 一个组a, 先计算a[0] 到 其他元素的和， s
        // s = (a[1] - a[0]) + a[2] - a[0] +... +a[n] - a[0])   n - 1 项
        //  a[1] -->  (a[1] - a[0]) + (a[2] - a[1]) + ... + (a[n] - a[1])
        //  s[a[3]] -> (a[3] - a[0]+  (a[3] - a[1]) +... + (a[n] - a[3])

        // s - s[a[1]] =   (a[1] - a[0]) * (n - 2) --> s[a[1]] = s- (n - 2) * (a[1] - a[0]);

        // 得 s[a[i]] = s + (2*i - n) * (a[i] - a[i - 1])


        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // 计算和
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[n];

        for (List<Integer> value : map.values()) {
            int m = value.size();

            long s = 0;
            for(int x : value){
                s += (x - value.get(0));
            }

            ans[value.get(0)] = s;

            for (int i = 1; i < m; i++) {
                ans[value.get(i)] = s += (long) (i * 2 - m) * (value.get(i) - value.get(i - 1));
            }
        }

        return ans;
    }
}
