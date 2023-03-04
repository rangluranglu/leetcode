package Year2023.Daily.M3.D4;

public class q982 {
    public int countTriplets(int[] nums) {
        // 按位与 == 0 ,    i, j , k
        // 三元组
        // 思考： 怎么是0？？ 有一位是0

        // 有条件枚举

        int[] cnt = new int[1 << 16];
        for(int x : nums){
            for(int y : nums){
                cnt[x & y] ++;
            }
        }

        int ans = 0;
        for(int z : nums){
            // 异或， sub 是z的子集
            z = z ^ 0xffff;
            // 枚举子集
            for(int sub = z; sub != 0; sub = (sub - 1) & z){
                ans += cnt[sub];
            }
            ans += cnt[0];
        }

        return ans;
    }
}
