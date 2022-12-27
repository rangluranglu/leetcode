package WeekCompetition.year2022.DW93;

public class q2499 {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        long ans = 0L;

        // 数对个数swapCnt, 众数 mode 及其出现次数 modeCount
        // 分类讨论：
        // 如过 modeCount 没有超过 swapCnt的一半
            // swapCnt 是奇数， 至少有三种不同的x, 其中一个数可以和 nums[0] 交换
            // 偶数， 两两交换

        // 超过一半：   modeCount * 2 > swapCnt ， 鸽巢原理无法重新排这些数字，让数组不相等，
        // 需要寻找其他满足nums[j] != nums2[j] 的数对， 且数不等于mode， 知道modeCount * 2 <= swapCnt;
        int swapCnt = 0, modeCnt = 0, mode = 0, n = nums1.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int x = nums1[i];
            // 相等
            if(x == nums2[i]){
                ans += i;
                swapCnt++;
                cnt[x]++;
                if(cnt[x] > modeCnt){
                    modeCnt = cnt[x];
                    mode = x;
                }
            }
        }


        for(int i = 0; i < n && modeCnt * 2 > swapCnt; i++){
            int x = nums1[i];
            int y = nums2[i];

            if(x != y && x != mode && y != mode){
                ans += i;
                ++swapCnt;
            }
        }

        return modeCnt * 2 > swapCnt ? -1 : ans;

    }
}
