package Year2023.Week.W339;

public class q2609 {
    public int findTheLongestBalancedSubstring(String s) {

        int i = 0, n = s.length();
        int ans = 0;
        while (i < n){
            int cntZero = 0;
            while (i < n && s.charAt(i) == '1'){
                i++;
            }
            while (i < n && s.charAt(i) == '0'){
                i ++;
                cntZero ++;
            }
            int cat = cntZero;

            while (i < n && cntZero > 0 && s.charAt(i) == '1'){
                i ++;
                cntZero --;
            }
            ans = Math.max(ans, (cat - cntZero) * 2);

        }
        return ans;
    }
}
