package Year2023.Daily.M2.D1;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.Map;

public class q2325 {
    public String decodeMessage(String key, String message) {
        // 制造对照表

        Map<Character, Character> map = new HashMap<>();
        char value = 'a';
        for(char c : key.toCharArray()){
            if(c != ' ' && !map.containsKey(c)){
                map.put(c, value);
                value ++;
            }


            if(value > 'z'){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : message.toCharArray()){
            if(c == ' '){
                sb.append(' ');
            }else {
                sb.append(map.get(c));
            }
        }

        return sb.toString();

    }
}
