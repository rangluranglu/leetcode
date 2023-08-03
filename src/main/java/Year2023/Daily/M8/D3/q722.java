package Year2023.Daily.M8.D3;

import java.util.ArrayList;
import java.util.List;

public class q722 {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;
        for(String s : source){
            if(inBlock){
                if(s.contains("*/")) {
                    int idx = s.indexOf("*/");
                    if (idx != 0){
                        ans.add(s.substring(idx + 2, s.length()));
                    }
                    inBlock = false;
                }
                continue;
            }

            if(s.contains("//")) {
                int idx = s.indexOf("//");
                if (idx == 0) {
                    continue;
                } else {
                    ans.add(s.substring(0, idx));
                }
            }else if(s.contains("/*")) {
                int idx = s.indexOf("/*");

                if(s.contains("*/")){
                    continue;
                }
                if(idx != 0) {
                    ans.add(s.substring(0, idx));
                }

                inBlock = true;
            }else {
                ans.add(s);
            }
        }

        return ans;
    }
}
