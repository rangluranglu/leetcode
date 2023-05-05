package Year2023.Daily.M5.D3;

import java.util.ArrayDeque;
import java.util.Deque;

public class q1003 {
    public boolean isValid(String s) {
        // 用栈模拟

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            sb.append(c);

            if(sb.length() >= 3 && sb.substring(sb.length() - 3).equals("abc")){
                sb.delete(sb.length() - 3, sb.length());
            }
        }

        return sb.length() == 0;
    }
}
