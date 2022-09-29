package question;

public class q263 {
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }

        int[] factors = {2, 3, 5};
        for(int fac : factors){
            while(n % fac == 0){
                n /= fac;
            }
        }

        return n == 1;
    }
}
