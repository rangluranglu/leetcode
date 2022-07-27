package Daily.year2022.M7.D27;

import java.nio.channels.Channel;

public class q592 {
    public String fractionAddition(String expression) {
        long a = 0, b = 1;

        int n = expression.length(), index = 0;

        while(index < n){
            long a1 = 0, flag = 1;

            if(expression.charAt(index) == '-' || expression.charAt(index) == '+'){
                flag = expression.charAt(index) == '-' ? -1 : 1;
                index ++;
            }

            // 找到分子
            while(index < n && expression.charAt(index) != '/'){
                a1 = a1 * 10 + expression.charAt(index) - '0';
                index ++;
            }
            a1 = a1 * flag;
            index ++;
            long b1 = 0;
            // 找到分母
            while(index < n && Character.isDigit(expression.charAt(index))){
                b1 = b1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            a = a * b1 + b * a1;
            b = b * b1;
        }
        if(a == 0){
            return "0/1";
        }

        long g = gcd(Math.abs(a), b);
        return Long.toString(a/g) + "/" + Long.toString(b/g);

    }

    long gcd(long a, long b){
        long ret = a % b;
        while(ret != 0){
            a = b;
            b = ret;
            ret = a % b;
        }
        return b;
    }
}
