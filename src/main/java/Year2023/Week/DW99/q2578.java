package Year2023.Week.DW99;

import java.util.Arrays;

public class q2578 {
    public int splitNum(int num) {
        // 最小
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);

        int a = 0, b = 0;
        for (int i = 0; i < chars.length; i++) {
            if(i % 2 == 0 ){
                a *= 10;
                a += chars[i] - '0';
            }else{
                b *= 10;
                b += chars[i] - '0';
            }
        }

        return a + b;

    }
}
