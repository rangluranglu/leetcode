package Year2023.Week.DW103;

public class q2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // 公共元素
        int n = A.length;
        int[] ans = new int[n];
        int[] cnt = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if(i > 0){
                ans[i] = ans[i - 1];
            }

            cnt[A[i]] ++;
            if(cnt[A[i]] == 2){
                ans[i]++;
            }
            cnt[B[i]] ++;
            if(cnt[B[i]] == 2){
                ans[i] ++;
            }
        }

        return ans;
    }
}
