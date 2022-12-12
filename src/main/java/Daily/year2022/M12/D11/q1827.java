package Daily.year2022.M12.D11;

public class q1827 {
    public int minOperations(int[] nums) {

        int ans = 0, last = -1;
        for(int num : nums){
            if(num > last){
                last = num;
            }else {
                ans += (last + 1 - num);
                last += 1;
            }
        }

        return ans;
    }
}
