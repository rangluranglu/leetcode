package Year2023.Daily.M1.D29;

public class q2315 {
    public int countAsterisks(String s) {
        int index = 0, n = s.length();
        int ans = 0;
        while (index < n){
            if(s.charAt(index) == '|'){
                index ++;
                while (s.charAt(index) != '|'){
                    index ++;
                }
            }else {
                if(s.charAt(index) == '*'){
                    ans ++;
                }
            }
            index ++;
        }
        return ans;
    }
}
