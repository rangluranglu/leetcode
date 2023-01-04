package Year2023.Daily.M1.D4;

public class q1802 {

    public int maxValue(int n, int index, int maxSum) {
        // 贪心 + 二分
        int left = 1, right = maxSum;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(n, index, mid, maxSum)){
                // 符合条件
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return right;
    }

    public boolean check(int n, int index, int mid, int maxSum){
        int left = index;
        int right = n - index - 1;

        return mid + cal(mid, left) + cal(mid, right) <= maxSum;
    }

    private long cal(int big, int length){
        if(length + 1 < big){
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        }else{
            int ones = length - (big - 1);

            return (long) big * (big - 1) / 2 + ones;
        }
    }
}
