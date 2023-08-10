package Year2023.Week.WN357;

import java.util.List;

public class q6953 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        // 为1 或大于等于m
        // 一定会是最左或最右
        int n = nums.size();
        if(n <= 2){
            return true;
        }


        for(int i = 1; i < n; i++){
            if(nums.get(i - 1) + nums.get(i) >= m){
                return true;
            }
        }

        return false;
    }
}
