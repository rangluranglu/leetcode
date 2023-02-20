package Year2023.Week.atemplate;

import java.lang.reflect.Array;
import java.util.*;

public class question2 {
    public int minOperations(int n) {
        // 二进制 连续的1
        //n 最低位为0则右移，不增加操作数
        //n 的二进制末尾有连续两个 1 以上做 +1 操作， step++
        //n 的二进制末尾只有一个 1 做 - 操作， step++
        int step = 0;

        while (n > 0){
            // 两个连续的1
            if((n & 3) == 1){
                n ++;
                step ++;
            }

            if((n & 1) == 1){
                step ++;
            }

            n >>= 1;
        }

        return step;
    }

}
