package Year2023.Week.atemplate;

public class question1 {
    public static void main(String[] args) {
        System.out.println(cal(15,49));
    }
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i = 0; i < n / 2; i++){
            ans += cal(nums[i], nums[n - 1 - i]);
        }

        if((n & 1) == 1){
            return ans + nums[n / 2];
        }

        return ans;

    }

    public static long cal(int a, int b){
        int n = 1, c = b;
        while (b !=0){
            b /= 10;
            n *= 10;
        }
        return (long) a * n + c;
    }
}
