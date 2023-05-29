package Year2023.Daily.M5.D29;

public class q2455 {
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums){
            if(num % 6 == 0){
                sum += num;
                count ++;
            }
        }
        if(count == 0){
            return 0;
        }
        return sum / count;
    }
}
