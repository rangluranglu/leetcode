package WeekCompetition.year2022.DW92;

public class q2484 {
    private static int MOD = (int) 1e9 + 7;
    public int countPalindromes(String s) {
        // 长度位5 的回文子序列数目
        // 回文子序列 ， 子序列 顺序 不能变
        // 逆序遍历：统计字符出现次数和两个字符的组合个数
        // 正序遍历：统计字符出现次数和两个字符的组合个数
        // 枚举每个 s[i] 作为中心
        char[] chars = s.toCharArray();
        int[] pre = new int[10], suf = new int[10];
        int[][] pre2 = new int[10][10], suf2 = new int[10][10];

        for(int i = chars.length - 1; i >= 0; i--){
            int d = chars[i] - '0';
            for(int j = 0; j < 10; j++){
                suf2[d][j] += suf[j];
            }

            suf[d] ++;
        }

        long ans = 0L;
        for(char d : chars){
            d -= '0';
            --suf[d];

            for(int j = 0; j < 10; j++){
                suf2[d][j] -= suf[j];
            }

            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    ans += (long) pre2[j][k] * suf2[j][k];
                }
            }

            for(int j = 0; j < 10; j++){
                pre2[d][j] += pre[j];
            }

            pre[d]++;

        }

        return (int) (ans % MOD);
    }
}
