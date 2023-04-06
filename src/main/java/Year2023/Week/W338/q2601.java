package Year2023.Week.W338;

public class q2601 {

    private final static int MX = 1000;
    private final  static int[] primes = new int[169];

    static {
        // 质数筛， 列出所有质数
        boolean[] np = new boolean[MX + 1];
        int pi = 1;
        for (int i = 2; i <= MX; i++) {
            if(!np[i]){
                primes[pi ++] = i;
                for(int j = i; j <= MX / i; j++){
                    np[i * j] = true;
                }
            }
        }
    }
    public boolean primeSubOperation(int[] nums) {
        // 质数筛 + 二分

        // pre 是上一个减完之后的数字
        // x = nums[i] 为当前数字， x - p > pre --> p < x - pre 的最大质数

        int pre = 0;
        for(int x : nums){
            if(x <= pre){
                return false;
            }

            int j = lowerBound(primes, x - pre);

            pre = x - primes[j - 1];
        }
        return true;
    }

    private int lowerBound(int[] nums, int target){
        // 找到大于等于 target 的坐标
        int left = 0, right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }

        return left;
    }
}
