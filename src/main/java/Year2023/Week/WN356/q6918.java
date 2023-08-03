package Year2023.Week.WN356;

import java.util.Arrays;
import java.util.Map;

public class q6918 {
    public String minimumString(String a, String b, String c) {
        // 三个字符串abc，最短的字符串，abc 是它的子串
        // 字典序最小

        if(a.contains(b) || c.contains(b)){
            b = "";
        }

        if(b.contains(a) || c.contains(a)){
            a = "";
        }

        if(a.contains(c) || b.contains(c)){
            c = "";
        }

        // 枚举
        String[] str = new String[]{a, b, c};

        // 枚举6种排列
        for (int i = 0; i < 6; i++) {

        }
        return "";
    }
}
