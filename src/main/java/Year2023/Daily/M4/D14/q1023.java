package Year2023.Daily.M4.D14;

import java.util.ArrayList;
import java.util.List;

public class q1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        // 解析pattern 小写字母插入pattern 得到 queries
        // --> queries 删除 pattern 得到的是小写字母 --> 成立
        List<Boolean> ans = new ArrayList<>();

        for(String query : queries){
            // 双指针
            boolean flag = true;
            int p = 0;
            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                if(p < pattern.length() && pattern.charAt(p) == c){
                    p ++;
                }else if(Character.isUpperCase(c)){
                    flag = false;
                    break;
                }
            }

            if(p < pattern.length()){
                flag = false;
            }

            ans.add(flag);
        }

        return ans;
    }
}
