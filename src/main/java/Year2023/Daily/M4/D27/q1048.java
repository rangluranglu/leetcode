package Year2023.Daily.M4.D27;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1048 {

    public int longestStrChain(String[] words) {
        // 动态规划
        // dp[i] 表示 i最长 长度

        // 长度排序
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int i = 0; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(words[j].length() < words[i].length() - 1){
                    break;
                }

                if(words[j].length() == words[i].length() - 1 && check(words[j], words[i])){
                    dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + 1);

                    ans = Math.max(ans, dp[i + 1]);
                }
            }
        }
        return ans;
    }

    private boolean check(String a, String b){
        for(int i = 0 ; i < b.length(); i++){
            if(a.equals(b.substring(0, i) + b.substring(i + 1))){
                return true;
            }
        }
        return false;
    }


    public int longestStrChain2(String[] words) {
        // 动态规划
        // 使用删除代替添加
        // 1. 字符串长度排序
        // 2. 遍历每个words[i] ， 初始以words[i] 为结尾的最长链长度 cnt[word[i]] 为1
        // 3. 依次取点每个字符， 在哈希表中招
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int ans = 0;
        Map<String, Integer> cnt = new HashMap<>();

        for(String word : words){
            cnt.put(word, 1);

            for(int i = 0; i < word.length(); i++){
                String prev = word.substring(0, i) + word.substring(i + 1);
                if(cnt.containsKey(prev)){
                    cnt.put(word, Math.max(cnt.get(word), cnt.get(prev) + 1));
                }
            }

            ans = Math.max(ans, cnt.get(word));
        }
        return ans;
    }
}
