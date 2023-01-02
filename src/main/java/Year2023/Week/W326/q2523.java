package Year2023.Week.W326;

public class q2523 {

    private static int MX = (int) 1e6;
    private static int[] primes = new int[78500];

    static {
        boolean[] np = new boolean[MX + 1];

        int pi = 0;

        for(int i = 2; i <= MX; i++){
            if(!np[i]){
                primes[pi ++] = i;
                for(int j = 1; j <= MX / i; j++){
                    np[i * j] = true;
                }
            }
        }

        primes[pi ++] = MX + 1;
        primes[pi ++] = MX + 1;
    }

    public int[] closestPrimes(int left, int right) {
        // 筛质数， 做法见q204
        // 找范围内的第一个质数可以用二分查找。
        //可以往质数表末尾额外插入 2 个 10^6+1 ，这样无需判断下标是否越界

        int p = -1, q = -1;
        for(int i = lowerBound(primes, left); primes[i + 1] <= right; i++){
            if(p < 0 || primes[i + 1] - primes[i] < q - p){
                p = primes[i];
                q = primes[i + 1];
            }
        }

        return new int[]{p, q};
    }


    private int lowerBound(int[] nums, int target){
        int left = -1, right = nums.length;

        while (left + 1 < right){

            int mid = left + (right - left) / 2;

            if(nums[mid] < target){
                left = mid;
            }else {
                right = mid;
            }
        }

        return right;
    }
}
