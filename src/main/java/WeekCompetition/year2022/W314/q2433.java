package WeekCompetition.year2022.W314;

public class q2433 {
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        for (int i = 0; i < pref.length; i++) {
            if(i == 0){
                ans[i] = pref[i];
            }else {
                ans[i] = pref[i - 1] ^ pref[i];
            }
        }

        return ans;
    }
}
