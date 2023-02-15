package Year2023.Daily.M2.D15;

public class q1205 {
    public boolean isGoodArray(int[] nums) {
        // 分解问题： 有无两个子集 的 最大公约数

        // 裴蜀定理： 对于不全为零的任意整数 a 和 b，记 g = gcd(a,b)， 对于任意整数x, y
        // 满足 a * x + b * y 是 g 的倍数

        int div = nums[0];
        for (int num : nums) {
            div = gcd(num, div);
            if(div == 1){
                break;
            }
        }

        return div == 1;
    }


    public int gcd(int a, int b){
        while (b != 0){
            int tmp = a;
            a = b;
            b = tmp % b;
        }

        return a;
    }
}
