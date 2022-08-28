package Daily.year2022.M8.D28;

public class q793 {
    public int preimageSizeFZF(int k) {
        // 二分搜索 5 因子是否等于k
        return (int) (help(k + 1) - help(k));
    }

    public long help(int k ){
        long r = 5L * k;
        long l = 0L;

        while(l <= r){
            long mid = (l + r) / 2;
            if(zeta(mid) < k){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l + 1;
    }

    public long zeta(long x){
        long res = 0;
        while(x != 0){
            res += x / 5;
            x /= 5;
        }

        return res;
    }
}
