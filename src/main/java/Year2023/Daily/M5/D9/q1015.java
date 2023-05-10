package Year2023.Daily.M5.D9;

public class q1015 {
    public int smallestRepunitDivByK(int k) {
        // resnew = (resold * 10 + 1) mod k

        if(k %  2 == 0 ||k% 5 == 0){
            return -1;
        }

        int resid = 1 % k, len = 1;

        while (resid != 0){
            resid = (resid * 10 +1) % k;
            len ++;
        }

        return len;

    }
}
