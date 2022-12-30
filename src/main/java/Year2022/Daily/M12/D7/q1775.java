package Year2022.Daily.M12.D7;

public class q1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        // 最大值 小于 最小值
        if(6 * n < m || 6 * m < n){
            return -1;
        }

        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;

        for (int i : nums1) {
            cnt1[i] ++;
            diff += i;
        }

        for (int i : nums2) {
            cnt2[i] ++;
            diff -= i;
        }

        if(diff == 0){
            return 0;
        }

        if(diff > 0){
            return help(cnt2, cnt1, diff);
        }

        return help(cnt1, cnt2, -diff);
    }


    // h1 小， h2 大， diff 正数
    public int help(int[] h1, int[] h2, int diff){
        int[] h = new int[7];

        for (int i = 1; i < 7; i++) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }

        int res = 0;
        for(int i = 5; i > 0 && diff > 0; i--){
            int t = Math.min((diff + i - 1)/ i, h[i]);

            res += t;
            diff -= t * i;
        }

        return res;
    }
}
