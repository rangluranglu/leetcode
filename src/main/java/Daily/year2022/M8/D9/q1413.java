package Daily.year2022.M8.D9;

public class q1413 {
    public int minStartValue(int[] nums) {
        int resMin = 0, sum = 0;
        for(int num : nums){
            sum += num;
            resMin = Math.min(resMin, sum);
        }

        return -resMin + 1;
    }
}
