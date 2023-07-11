package Year2023.Week.W353;

public class q2772 {
    public boolean checkArray(int[] nums, int k) {
        // 长度为k， 模拟
        // 差分数组 维护同时减去一个数
        int n = nums.length, sumD = 0;
        int[] d = new int[n];
        d[0] = nums[0];
        for(int i = 1; i < n; i++){
            d[i] = nums[i] - nums[i - 1];
        }

        for(int i = 0; i < n; i++){
            if(d[i] == 0){
                continue;
            }

            if(d[i] < 0 || i + k> n){
                return false;
            }

            if(i + k < n){
                d[i + k] += d[i];
            }
            d[i] -= d[i];
        }

        return true;
    }
}
