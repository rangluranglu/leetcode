package Year2022.Daily.M12.D15;

public class q1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }

        String digits = sb.toString();

        while (k-- > 0 && digits.length() > 1){
            int sum = 0;

            for (int i = 0; i < digits.length(); i++) {
                char ch = digits.charAt(i);
                sum += ch - '0';
            }

            digits = Integer.toString(sum);
        }

        return Integer.parseInt(digits);
    }
}
