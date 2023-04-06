package Year2023.Daily.M4.D6;

public class q1017 {
    public String baseNeg2(int n) {
        // 负二进制
        // i是偶数 2^i = (-2)^i
        // i是奇数 2^i = (-2)^(i+1) + (-2)^i

        if(n == 0){
            return "0";
        }

        int[] bits = new int[32];
        for (int i = 0; i < 32 && n != 0; i++) {
            if((n & 1) != 0){
                bits[i] ++;
                if((i & 1) != 0){
                    bits[i + 1]++;
                }
            }
            n >>= 1;
        }

        int carry = 0;
        for(int i = 0; i < 32; i++){
            int val = carry + bits[i];
            bits[i] = val & 1;
            carry = (val - bits[i]) / (-2);
        }

        int pos = 31;
        StringBuilder sb = new StringBuilder();
        while (pos >= 0 && bits[pos] == 0){
            pos --;
        }

        while (pos >= 0){
            sb.append(bits[pos]);
            pos --;
        }

        return sb.toString();
    }

    public String baseNeg22(int n) {
        // 负二进制
        // 进制转换
        if(n == 0 || n == 1){
            return String.valueOf(n);
        }


        StringBuilder sb = new StringBuilder();
        while (n != 0){
            int remainder = n & 1;
            sb.append(remainder);
            n -= remainder;
            n /= -2;
        }

        return sb.reverse().toString();

    }
}
