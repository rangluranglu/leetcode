package Year2022.Daily.M12.D17;

public class q1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        // 双指针 + 贪心
        int i = 0;

        for(int k = 0; k < nums.length && i < groups.length; ){
            if(check(groups[i], nums, k)){
                k += groups[i].length;
                i ++;
            }else {
                k ++;
            }
        }

        return i == groups.length;
    }


    public boolean check(int[] g, int[] nums, int k){
        if(k + g.length > nums.length){
            return false;
        }

        for (int i = 0; i < g.length; i++) {
            if(g[i] != nums[k + i]){
                return false;
            }
        }

        return true;
    }
}
