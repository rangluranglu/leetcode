package Year2023.Week.W347;

public class q2712 {
    public long minimumCost(String s) {
        // 0 - i 成本 i + 1  --> 长度
        // i - n-1 成本 n - 1 --> 长度

        // 字符相等的最小成本, 从中间向两边

        long ans = 0;

        char[] chars = s.toCharArray();
        int n = chars.length;

        for(int i = 1; i < n; i++){
            if(chars[i - 1] == chars[i]){
                ans += Math.min(i, n - i);
            }
        }

        return ans;

    }
}
