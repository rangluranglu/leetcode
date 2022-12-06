package WeekCompetition.year2022.DW89;

public class q2439 {
    public int minimizeArrayValue(int[] nums) {
        long max = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            max = Math.max(max, (sum + i) / (i + 1));  // 向上取整
        }

        return (int)max;
    }

    public int minimizeArrayValue2(int[] nums) {
        // 二分答案

        //前方的较小数可以接受后方较大数多余的数字

        int left = 0, right = 1000000000;

        while (left < right){
            int mid = left +(right - left) / 2;

            if(check(nums, mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int[] nums, int k) {

        long have = 0;

        for(int n : nums){
            if(n <= k){
                have += (k - n);
            }else {
                if(have < n - k){
                    return false;
                }else {
                    have -= (n -k);
                }
            }
        }

        return true;
    }
}
