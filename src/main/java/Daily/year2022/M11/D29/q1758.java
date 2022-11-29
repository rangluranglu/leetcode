package Daily.year2022.M11.D29;

public class q1758 {
    public int minOperations(String s) {
        // 交替

        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != (char) '0' + i % 2){
                cnt++;
            }
        }

        return Math.min(cnt, s.length() - cnt);

    }
}
