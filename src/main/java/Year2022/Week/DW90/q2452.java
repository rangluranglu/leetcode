package Year2022.Week.DW90;

import java.util.ArrayList;
import java.util.List;

public class q2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        // 编辑距离 --> 小于两次

        List<String> ans = new ArrayList<>();

        for(String s :queries){
            if(isValid(s, dictionary)){
                ans.add(s);
            }
        }

        return ans;
    }

    private boolean isValid(String s, String[] dictionary){
        for(String word : dictionary){
            // 遍历dic
            int count = 0;

            for (int i = 0; i < word.length(); i++) {
                if(s.charAt(i) != word.charAt(i)){
                    count ++;
                }

                if(count > 2){
                    break;
                }
            }

            if(count <= 2){
                return true;
            }
        }

        return false;
    }
}
