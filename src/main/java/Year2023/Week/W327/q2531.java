package Year2023.Week.W327;

public class q2531 {
    public boolean isItPossible(String word1, String word2) {
         // 条件讨论
        int m = word1.length(), n = word2.length();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < m; i++) {
            cnt1[word1.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < n; i++) {
            cnt2[word2.charAt(i) - 'a'] ++;
        }

        int num1 = 0, num2 = 0;
        for (int i = 0; i < 26; i++) {
            num1 += cnt1[i] == 0 ? 0 : 1;
            num2 += cnt2[i] == 0 ? 0 : 1;
        }

        for (int i = 0; i < 26; i++) {
            if(cnt1[i] == 0){
                continue;
            }

            for(int j = 0; j < 26; j++){
                if(cnt2[j] == 0){
                    continue;
                }

                if(i == j){
                    if(num1 == num2){
                        return true;
                    }
                }else if(((num1 - (cnt1[i] == 1 ? 1 : 0)) + (cnt1[j] == 0 ? 1 : 0)) == ((num2 - (cnt2[j] == 1 ? 1 : 0)) + (cnt2[i] == 0 ? 1 : 0))){
                    return true;
                }
            }
        }

        return false;
    }
}
