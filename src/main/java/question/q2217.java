package question;

public class q2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        // 指定长度的回文数
        // n 为 偶数 n = 2 * i
        // n 为 奇数 n = 2 * i - 1

        int l = (intLength + 1) / 2; // 前半部分长度
        int start = (int) Math.pow(10, l - 1) - 1;
        // 回文数量
        long count = 9L * (start + 1);

        int limit = (int) Math.pow(10, l) - 1;

        long[] ans = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if(queries[i] > count){
                ans[i] = -1;
            }else{
                long num = start + queries[i];
                ans[i] = reverse(num, intLength);
            }
        }

        return ans;
    }

    private long reverse(long num, int intLength){
        String s = String.valueOf(num);
        int index = s.length() * 2 == intLength ? s.length() - 1 : s.length() - 2;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = index; i >= 0; i--){
            sb.append(s.charAt(i));
        }

        return Long.valueOf(sb.toString());
    }
}
