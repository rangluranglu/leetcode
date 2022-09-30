package question;

public class q409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for(char ch : s.toCharArray()){
            count[ch] ++;
        }
        int ans = 0;
        for (int i = 0; i < 128; i++) {
            ans += count[i] / 2 * 2;
            if(count[i] % 2 == 1 && ans % 2 == 0){
                ans ++;
            }
        }

        return ans;
    }
}
