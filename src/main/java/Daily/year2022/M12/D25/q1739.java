package Daily.year2022.M12.D25;

public class q1739 {
    public int minimumBoxes(int n) {
        // 找规律
        // 第i层最多可以增加 i 个接触地面的盒子  所带来的收益是 i * (i + 1) / 2;

        // 放置n个盒子， 放满i-1 层，剩余的盒子用第i层的j个

        int cur = 1, i= 1, j = 1;

        while (n > cur){
            n -= cur;
            i ++;
            cur += i;
        }

        cur = 1;
        while (n > cur){
            n -= cur;
            j++;
            cur++;
        }

        return (i - 1) * i / 2 + j;
    }


    public int minimumBoxes2(int n) {
        // 求解 f(j) = j * (j + 1) / 2 >= n

        int cur = 1, i= 1, j = 1;

        while (n > cur){
            n -= cur;
            i ++;
            cur += i;
        }

        cur = 1;
        while (n > cur){
            n -= cur;
            j++;
            cur++;
        }

        return (i - 1) * i / 2 + j;
    }
}
