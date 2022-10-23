package WeekCompetition.year2022.atemplate;

public class question2 {
    public int subarrayGCD(int[] nums, int k) {

        // 最大公约数
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            int tmp = nums[i];

            for(int j = i; j < n; j++){
                tmp = findGCD(tmp, nums[j]);
                if(tmp == k){
                    ans += 1;
                }else if(tmp % k != 0){
                    break;
                }
            }
        }

        return ans;

    }
    
    public int findGCD(int a, int b){
        if(b > a){
            return findGCD(b, a);
        }

        // a >= b;
        int c = 0;

        while(a % b != 0){
            c = a % b;
            a = b;
            b = c;
        }

        return c;

    }
}
