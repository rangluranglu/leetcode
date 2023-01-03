package Year2023.Daily.M1.D3;

import java.util.Calendar;

public class q2042 {
    public boolean areNumbersAscending(String s) {
        int n = s.length();
        int last = -1;
        for (int i = 0; i < n; ) {
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while (i <n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }

                if(num > last){
                    last = num;
                }else {
                    return false;
                }
            }else {
                i ++;
            }
        }

        return true;
    }
}
