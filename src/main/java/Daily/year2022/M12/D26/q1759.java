package Daily.year2022.M12.D26;

public class q1759 {
    int mod = (int) 1e9 + 7;
    public int countHomogenous(String s) {
        int i = 0, n = s.length();
        int ans = 0;
        while (i < n){
            int j = i;

            while(j < n && s.charAt(j) == s.charAt(i)){
                j ++;
            }

            ans += ((long) (j - i) * (j - i + 1) / 2) % mod;

            i = j;
        }

        return  ans;

    }
}
