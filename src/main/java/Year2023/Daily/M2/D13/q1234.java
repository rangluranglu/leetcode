package Year2023.Daily.M2.D13;

public class q1234 {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;
        int[] cnt = new int[26];

        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'A']  += 1;
        }

        int res = n;
        if(check(cnt, target)){
            return 0;
        }

        for(int l = 0, r = 0; l < s.length(); l++){
            while (r < s.length() && !check(cnt, target)){
                cnt[s.charAt(r) - 'A']--;
                r++;
            }

            if(!check(cnt, target)){
                break;
            }

            res = Math.min(res, r - l);
            cnt[s.charAt(l) - 'A'] ++;
        }

        return res;

    }


    public boolean check(int[] cnt, int target){
        if(cnt['Q' - 'A'] > target || cnt['W' - 'A'] > target ||cnt['E' - 'A'] > target ||cnt['R' - 'A'] > target){
            return false;
        }

        return true;
    }
}
