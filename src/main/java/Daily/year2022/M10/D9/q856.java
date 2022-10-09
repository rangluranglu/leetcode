package Daily.year2022.M10.D9;

import java.util.ArrayDeque;
import java.util.Deque;

public class q856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                st.push(0);
            }else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }

        return st.peek();
    }

    public int scoreOfParentheses2(String s) {
        int deep = 0, n = s.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            deep += (s.charAt(i) == '(' ? 1 : -1);
            if(s.charAt(i) == ')' && s.charAt(i - 1) == '('){
                ans += 1 << deep;
            }
        }
        return ans;
    }
}
