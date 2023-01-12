package Year2023.Daily.M1.D12;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> wordMap = new HashMap<>();

        for(List<String> w : knowledge){
            wordMap.put(w.get(0), w.get(1));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ){
            if(s.charAt(i) == '('){
                StringBuilder key = new StringBuilder();
                while (++i < s.length() && s.charAt(i) != ')'){
                   key.append(s.charAt(i));
                }
                i++;
                sb.append(wordMap.containsKey(key.toString()) ? wordMap.get(key.toString()) : '?');
            }else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
