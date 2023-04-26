package Year2023.Week.W340;

public class q2614 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(isPrime(nums[i][i])){
                ans = Math.max(ans, nums[i][i]);
            }

            if(isPrime(nums[i][n - i - 1])){
                ans = Math.max(ans, nums[i][n - i -1]);
            }
        }

        return ans;
    }

    private boolean isPrime(int x){
        if(x == 1){
            return false;
        }
        if(x == 2){
            return true;
        }
        for(int i = 2; i < Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;

    }
}
