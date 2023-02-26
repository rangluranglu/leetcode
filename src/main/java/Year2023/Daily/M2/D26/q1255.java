package Year2023.Daily.M2.D26;

public class q1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // 状态压缩dp

        int n = words.length;
        int ans = 0;
        int[] count = new int[26];

        for(char c : letters){
            count[c - 'a'] ++;
        }

        for(int s = 1; s < (1 << n); s++){
            int[] wordCount = new int[26];  // 统计子集s的数目
            for(int k = 0; k < n; k++){
                if((s & (1 << k)) == 0){  // words[k] 不在子集s中
                    continue;
                }

                for(int i = 0; i < words[k].length(); i++){
                    char c = words[k].charAt(i);
                    wordCount[c - 'a'] ++;
                }
            }

            boolean flag = true;
            int sum = 0;

            for (int i = 0; i < 26; i++) {
                sum += score[i] * wordCount[i];
                flag = flag && (wordCount[i] <= count[i]);
            }

            if(flag){
                ans = Math.max(sum, ans);
            }
        }

        return ans;
    }
}
