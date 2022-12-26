package WeekCompetition.year2022.W325;

public class q2516 {
    public int takeCharacters(String s, int k) {
        // 滑动窗口
        char[] cs = s.toCharArray();
        int[] freq = new int[3];

        for (char c : cs) {
            freq[c - 'a'] ++;
        }

        for (int i = 0; i < 3; i++) {
            if(freq[i] < k){
                return -1;
            }
        }


        int max = 0;
        int n = cs.length;
        int l = 0, r = 0;

        // 滑动窗口
        while (r < n){
            if(--freq[cs[r] - 'a'] < k){
                max = Math.max(max, r -l);
                while(freq[cs[r] - 'a'] < k){
                    freq[cs[l ++] - 'a']++;
                }
            }

            r++;
        }
        // 尾处理
        max = Math.max(max, r - l);

        return n - max;
    }


    public int takeCharacters2(String s, int k) {
        // 双指针
        char[] cs = s.toCharArray();
        int[] freq = new int[3];
        int n = cs.length, j = n;

        while (freq[0] < k || freq[1] < k || freq[2] < 2){
            if(j <= 0){
                return -1;
            }
            j --;
            freq[cs[j] - 'a'] ++;
        }

        int ans = n - j;

        for(int i = 0; i < n && j < n; i ++){
            freq[cs[i] - 'a'] ++;
            while (j < n && freq[cs[j] - 'a'] > k){
                freq[cs[j] - 'a'] --;
                j ++;
            }

            ans = Math.min(ans, i + 1 + n - j);
        }

        return ans;
    }
}
