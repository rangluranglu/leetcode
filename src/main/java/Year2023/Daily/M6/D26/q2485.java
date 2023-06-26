package Year2023.Daily.M6.D26;

public class q2485 {
    public int pivotInteger(int n) {
        // 找中枢整数
        // 计算1 - n 的和， 枚举
        int sum = (1 + n) * n / 2;

        for(int i = 1; i <= n; i++){
            if((1 + i) * i / 2 == sum + i){
                return i;
            }
        }

        return -1;
    }

    public int pivotInteger2(int n) {
        // 找中枢整数
        // 计算1 - n 的和， 枚举
        int t = (n * n + n) / 2;
        int x = (int) Math.sqrt(t);
        if (x * x == t) {
            return x;
        }
        return -1;
    }
}
