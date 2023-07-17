package Year2023.Daily.M7.D17;

public class q415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || add > 0){
            int num = (i >= 0 ? num1.charAt(i) - '0' : 0) + (j >= 0 ? num2.charAt(j) - '0' : 0) + add;
            add = num / 10;
            sb.append(num % 10);

            i --;
            j --;
        }

        return sb.reverse().toString();
    }
}
