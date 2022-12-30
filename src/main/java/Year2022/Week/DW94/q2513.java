package Year2022.Week.DW94;

public class q2513 {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        // 最大元素的最小值
        // 二分答案：
        // [x / d2] - [x / lcm] 是 arr1 独有
        // [x / d1] - [x / lcm] 是 arr2 独有
        // x - [x / d1] - [x / d2] + [x / lcm] 是 arr1 和 arr2 共享的
        // 条件为
        // x - [x / d1] - [x / d2] + [x / lcm] >= max(uniqueCnt1 - [x / d2] + [x / lcm], 0)+
        //       max(uniqueCnt2 - [x / d1] + [x / lcm], 0)

        int n =uniqueCnt1 + uniqueCnt2;
        int l = 0, r = 2 * n;
        long lcm = Countlcm(divisor1, divisor2);

        while (l <= r){
            int mid = l + (r - l) / 2;
            int val1 = (int) Math.max(uniqueCnt1 - mid / divisor2 + mid / lcm, 0);
            int val2 = (int) Math.max(uniqueCnt2 - mid/ divisor1 + mid / lcm, 0);
            int v = (int) (mid - mid / divisor1 - mid / divisor2 + mid / lcm);

            if(v >= val1 + val2){
                // 满足条件
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        System.out.println("r --" + r + "l--" + l);
        return l;

    }


    private int gcd(int a, int b){
        if(a < b){
            return gcd(b, a);
        }

        int c = a % b;
        while (c != 0){
            a = b;
            b = c;
            c = a % b;
        }
        return  b;
    }

    private long Countlcm(int a, int b){
        return (long) a * b / gcd(a, b);
    }
}
