package Year2023.Week.W342;

public class q2653 {
    public int sumOfMultiples(int n) {
        // m 的倍数有 [n/m] 个 利用等差数列求和计算

        int ans = 0;

        for(int i = 3; i <= n; i++){

            if(i % 3 == 0){
                ans+= i;
            }else if(i % 5 ==0){
                ans += i;
            }else if (i % 7 == 0){
                ans += i;
            }
        }

        return ans;
    }

    public int sumOfMultiples2(int n) {
        // 容斥原理
        // m 的倍数有 [n/m] 个 利用等差数列求和计算

        return sum(3, n) + sum(5, n) + sum(7, n) - sum(15, n) - sum(21, n) - sum(35, n) + sum(105, n);
    }

    private int sum(int m, int n){


        // 尾项 = (项数) * 差
        int last = n / m * m;
        // 项数
        int cnt = n / m;

        return (m + last) * cnt / 2;
    }
}
