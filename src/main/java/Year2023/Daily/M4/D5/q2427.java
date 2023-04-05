package Year2023.Daily.M4.D5;

public class q2427 {
    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int x = 1; x <= Math.min(a, b); ++x) {
            if (a % x == 0 && b % x == 0) {
                ++ans;
            }
        }
        return ans;
    }

    public int commonFactors2(int a, int b) {
        int c = gcd(a, b), ans = 0;
        for(int x = 1; x * x <= c; x++){
            if(c % x == 0){
                ans ++;
                if(x * x != c){
                    ans ++;
                }
            }
        }

        return ans;
    }

    public int gcd(int a, int b){
        while (b != 0){
            int tmp = a;
            a = b;
            b = tmp % a;
        }

        return a;
    }
}
