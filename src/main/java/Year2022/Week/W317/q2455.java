package Year2022.Week.W317;

public class q2455 {
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums){
            if(num % 6 == 0){
                sum += num;
                count ++;
            }
        }

        return sum / count;
    }
}
