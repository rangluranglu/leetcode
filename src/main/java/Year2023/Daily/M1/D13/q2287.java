package Year2023.Daily.M1.D13;

public class q2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] ++;
        }

        int[] t = new int[26];
        for (int i = 0; i < target.length(); i++) {
            t[target.charAt(i) - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if(t[i] > 0){
                ans = Math.min(ans, map[i] / t[i]);
            }
        }

        return ans;
    }
}
