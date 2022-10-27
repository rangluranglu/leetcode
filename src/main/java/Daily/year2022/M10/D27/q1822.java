package Daily.year2022.M10.D27;

public class q1822 {
    public int arraySign(int[] nums) {
        // 统计负数个数
        int count = 0;
        for(int num : nums){
            if(num == 0){
                return 0;
            }
            if(num < 0){
                count ++;
            }
        }

        return count % 2 == 0 ? 1 : -1;
    }
}
