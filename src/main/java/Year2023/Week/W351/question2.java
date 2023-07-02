package Year2023.Week.W351;

import java.lang.reflect.Array;
import java.util.*;

public class question2 {
    public int makeTheIntegerZero(int num1, int num2) {
        // 从小到大枚举答案
        // 简化 num1 - num2 * k 能否拆成 k个2^i 之和
        // 设 x = num1 - num2 * k;
        // x < 0  无解
        // x < k 无解
        // 如 x 中二进制1的个数大于k， 无法拆成k

        for (long k = 1; k <= num1 - num2 * k; k++){
            if(k >= Long.bitCount(num1 - num2 * k)){
                return (int) k;
            }
        }

        return -1;
    }

}
