package Year2022.Daily.M12.D16;

public class q1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }
        long diff = 0;
        if(sum > goal){
            diff = sum - goal;
        }else {
            diff = goal - sum;
        }

        return (int) ((diff + limit - 1) / limit);
    }
}
