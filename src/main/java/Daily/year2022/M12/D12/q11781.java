package Daily.year2022.M12.D12;

public class q11781 {
    public int beautySum(String s) {
        // s长度小于 500 --- > 暴力

        int n = s.length();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];

            int maxFreq = 0;
            for(int j = i; j < n; j++){
                cnt[s.charAt(j) - 'a'] ++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);

                int minFreq = s.length();

                for (int k = 0; k < 26; k++) {
                    if(cnt[k] > 0){
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }

                ans += maxFreq - minFreq;
            }
        }

        return ans;
    }
}
