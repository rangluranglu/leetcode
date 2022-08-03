package Daily.year2022.M8.D3;

import java.util.Arrays;

public class q899 {
    public String orderlyQueue(String s, int k) {
        // 脑筋急转弯
        // 如果k不为1, 总曾变为最小排列

        if(k == 1){
            StringBuilder sb = new StringBuilder(s);
            String ans = s;

            for (int i = 1; i < s.length(); i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);

                if(sb.toString().compareTo(ans) < 0){
                    ans = sb.toString();
                }
            }

            return ans;
        }else{
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

    }
}
