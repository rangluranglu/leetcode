package Year2023.Daily.M8.D1;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class q2681 {

    private static final int MOD = (int) 1e9 + 7;
    public int sumOfPower(int[] nums) {
        // 计算贡献
        // a,b ,c , d ,e  顺序从小到大
        // d 为最大值，
        // 只选d一个数，贡献为 d^3
        // 选a为最小值， 贡献为 d^2 * a * 2^2
        // 选b为最小值， 贡献为 d^2 * b * 2^1
        // 选c为最小值， 贡献为 d^2 * c * 2^0
        // d为最大值时，贡献为 d^3 + d^2 * (a * 2^2+ b * 2^1 + c * 2^0) = d^2 * (d + s)
        // e为最大值时， 贡献为 2 * s + d;


        long ans = 0, s = 0;
        Arrays.sort(nums);
        for(long num : nums){
            ans = (ans + num * num % MOD * (num + s))  % MOD;

            s = (s * 2 + num) % MOD;
        }

        return (int) ans;
    }
}
