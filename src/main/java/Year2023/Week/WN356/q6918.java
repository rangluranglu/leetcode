package Year2023.Week.WN356;

import java.util.Arrays;
import java.util.Map;

public class q6918 {
    public String minimumString(String a, String b, String c) {
        // 三个字符串abc，最短的字符串，abc 是它的子串
        // 字典序最小
        int n = a.length(), m = b.length(), l = c.length();
        String[] str = new String[]{a, b, c};
        Arrays.sort(str);

        if(str[0].contains(str[1])){
            if(str[0].contains(str[2])){
                return str[0]
            }
        }
    }
}
