package Year2022.Week.W321;

public class q2486 {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int m = s.length(), n = t.length();

        while (i < m && j < n){
            if(s.charAt(i) ==t.charAt(j)){
                i ++;
                j ++;
            }else {
                i ++;
            }
        }

        if(j == n){
            return 0;
        }else {
            return n - j;
        }
    }
}
