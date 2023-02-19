package Year2023.Week.atemplate;

import java.lang.reflect.Array;
import java.util.*;

public class question2 {
    public int minOperations(int n) {
        // 二进制 连续的1

        String bin = Integer.toBinaryString(n);
        int ans = 0;
        int cnt = 0;
        int i = 0;
        while (i < bin.length()){
            // 间隔是0
            while (i <bin.length() && bin.charAt(i) == '0'){
                i ++;
            }


            if(bin.charAt(i) == 0){
                if(i < bin.length() - 1 && bin.charAt(i + 1) == '1'){
                    cnt ++;
                    i++;
                }
            }
        }
    }

}
