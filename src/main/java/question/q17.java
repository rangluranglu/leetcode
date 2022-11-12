package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        dfs(0, digits, ans, phoneMap, new StringBuilder());
        return ans;
    }

    private void dfs(int i, String digits, List<String> ans, Map<Character, String> phoneMap, StringBuilder path) {
        if(i == digits.length()){
            ans.add(path.toString());
            return;
        }

        // 回溯
        char cur = digits.charAt(i);
        for (char ch : phoneMap.get(cur).toCharArray()){
            path.append(ch);
            dfs(i + 1, digits, ans, phoneMap, path);
            path.deleteCharAt(i);
        }
    }
}
