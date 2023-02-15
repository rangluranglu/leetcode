package Year2023.Week.W330;

public class q2550 {
    int mod = (int) 1e9 + 7;
    public int monkeyMove(int n) {
        // 至少发生一次碰撞的发放数
        // C n 2 有重复
        // 共有 2 ^ n 移动方式
        // 只有全部 顺时针或逆时针是不会碰撞

        return (int) ((quickPower(2, n) - 2 + mod) % mod);

        //
    }

    // 快速幂

    public long quickPower(long base, long power){
        long result = 1;
        while(power > 0){
            if(power % 2 == 1){
                result  = (result * base) % mod;
            }

            base = (base * base) % mod;
            power = power / 2;
        }

        return result;
    }
}
