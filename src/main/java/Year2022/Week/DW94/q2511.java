package Year2022.Week.DW94;

public class q2511 {
    public int captureForts(int[] forts) {
        int last = 0, lastIndex = -1;
        int n = forts.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(forts[i] != 0){
                // 是 1 或 -1
                if(last == 0){
                    last = forts[i];
                    lastIndex = i;
                }else if(last * forts[i] == -1){
                    last *= -1;
                    ans = Math.max(ans, i - lastIndex - 1);
                    lastIndex = i;
                }else {
                    lastIndex = i;
                }
            }
        }
        return ans;
    }
}
