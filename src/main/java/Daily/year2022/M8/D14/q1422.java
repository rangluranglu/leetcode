package Daily.year2022.M8.D14;

public class q1422 {
    public int maxScore(String s) {
        int score = 0;
        int n = s.length();
        if(s.charAt(0) == '0'){
            score += 1;
        }

        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '1'){
                score += 1;
            }
        }

        int ans = score;

        for(int i = 1; i < n - 1; i++){
            if(s.charAt(i) == '0'){
                score ++;
            }else{
                score --;
            }

            ans = Math.max(ans, score);
        }

        return ans;
    }
}
