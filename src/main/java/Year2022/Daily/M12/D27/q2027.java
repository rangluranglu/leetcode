package Year2022.Daily.M12.D27;

public class q2027 {
    public int minimumMoves(String s) {
            int ans = 0, index = 0;

            while (index < s.length()){
                while (index<s.length() && s.charAt(index) == 'O'){
                    index ++;
                }
                if(index < s.length()){
                    ans += 1;
                    index += 3;
                }

            }

            return ans;
    }
}
