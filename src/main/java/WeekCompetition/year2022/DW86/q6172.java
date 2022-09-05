package WeekCompetition.year2022.DW86;

public class q6172 {
    public boolean isStrictlyPalindromic(int n) {
        // b = n - 2;
        for(int i = 2; i <= n -2; i++){
            String b = findB(n, i);
            if(!check(b)){
                return false;
            }
        }

        return true;
    }

    private boolean check(String b) {
        int len = b.length();
        int i = 0, j = len - 1;
        while (i <= j){
            if(b.charAt(i) != b.charAt(j)){
                return false;
            }
            i ++;
            j --;
        }

        return true;
    }

    private String findB(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }
}
