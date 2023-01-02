package Year2023.Week.W326;

public class q2522 {

    public int minimumPartition(String s, int k) {
        // 贪心 字符串数目最少

        char[] chs = s.toCharArray();
        int n = chs.length;
        int ans = 0;
        for(int i = 0; i < chs.length; ){
            long num = chs[i] - '0';
            int j = i;
            while (j < n - 1 && num <= k){
                j++;
                num = num * 10 + chs[j] - '0';
            }
            if(num > k){
                num = num / 10;
                j --;
            }

            if(j < i){
                return -1;
            }
            ans ++;
            i = j + 1;
        }

        return ans;

    }
}
