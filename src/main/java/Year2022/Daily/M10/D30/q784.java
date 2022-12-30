package Year2022.Daily.M10.D30;

import java.util.ArrayList;
import java.util.List;

public class q784 {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();

        dfs(0, chars, ans);
        return ans;
    }

    private void dfs(int i, char[] chars, List<String> ans) {
        //
        if(i == chars.length){
            ans.add(new String(chars));
            return;
        }

        if(Character.isDigit(chars[i])){
            dfs(i + 1, chars, ans);
        }else {
            dfs(i + 1, chars, ans);
            if(Character.isLowerCase(chars[i])){
                chars[i] = Character.toUpperCase(chars[i]);
            }else{
                chars[i] = Character.toLowerCase(chars[i]);
            }

            dfs(i + 1, chars, ans);


            if(Character.isLowerCase(chars[i])){
                chars[i] = Character.toUpperCase(chars[i]);
            }
            if(Character.isUpperCase(chars[i])){
                chars[i] = Character.toLowerCase(chars[i]);
            }

        }
    }
}
