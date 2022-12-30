package question;

public class q8 {
    public int myAtoi(String s) {
        int num = 0;
        int flag = 1;

        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);

            if(i == 0 && a == '+'){
                flag = 1;
            }else if(i == 0 && a == '-'){
                flag = -1;
            }else if(Character.isDigit(a)) {
                int d = a - '0';
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && d > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }

                if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && -d < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                num = num * 10 + flag * d;
            }else {
                break;
            }
        }
        return num;
    }
}
