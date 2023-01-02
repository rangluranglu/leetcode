package Year2023.Week.atemplate;

public class question4 {

    public int[] closestPrimes(int left, int right) {
        // left <= num1 <nums2 <= right

        // 质数   最小值

        int last = -1;
        int[] ans = new int[]{-1, -1};
        int minD = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if(isPrime(i)){
                System.out.println("i + " +ans[0] + "j + " + ans[1]);
                if(last == -1){
                    last = i;
                }else {
                    return new int[]{last, i};
                }
            }
        }

        return ans;
    }

    private boolean isPrime(int num){
        if(num < 2){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}
