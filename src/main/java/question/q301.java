package question;

import java.util.ArrayList;
import java.util.List;

public class q301 {
    List<String> res;
    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;
        res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                lremove ++;
            }else if(s.charAt(i) == ')'){
                if(lremove == 0){
                    rremove ++;
                }else {
                    lremove --;
                }
            }
        }

        helper(s, 0, lremove, rremove);

        return res;
    }

    public void helper(String str, int index, int lremove, int rremove){
        if(lremove == 0 && rremove == 0){
            if(isVaild(str)){
                res.add(str);
            }
            return;
        }


        for(int i = index; i < str.length(); i++){
            // 去重
            if(i != index && str.charAt(i) == str.charAt(i - 1)){
                continue;
            }

            if(lremove + rremove > str.length() - i){
                return;
            }

            if(lremove > 0 && str.charAt(i) == '('){
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }

            if(rremove > 0 && str.charAt(i) == ')'){
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    public boolean isVaild(String str){
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                cnt ++;
            }else if(str.charAt(i) == ')'){
                cnt --;
                if(cnt < 0){
                    return false;
                }
            }
        }

        return cnt == 0;
    }
}
