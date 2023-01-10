package Year2023.Week.W327;

public class q2529 {
    public int maximumCount(int[] nums) {
        // 非递减
        int pos = 0, neg = 0;

        for(int num : nums){
            if(num < 0){
                neg ++;
            }

            if(num > 0){
                pos ++;
            }
        }

        return Math.max(pos, neg);

    }
}
