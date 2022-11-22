package Daily.year2022.M11.D22;

public class q878 {
    int MOD = (int) 1e9 + 7;
    public int nthMagicalNumber(int n, int a, int b) {
        // 二分法
        long lcm = (long) a * b / gcd(a, b) ;

        long left = 0, right = (long) Math.max(a, b) * n;

        while(left < right){
            long mid = left + (right - left) / 2;

            if(mid / a + mid / b - mid / lcm >= n){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return (int) (left % MOD);
    }


    private int gcd(int a, int b){
        if(b >a){
            return gcd(b, a);
        }

        int c = a % b;

        while (c != 0){
            a =b;
            b = c;
            c = a % b;
        }

        return b;
    }
}
