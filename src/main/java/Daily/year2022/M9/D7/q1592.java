package Daily.year2022.M9.D7;

import java.util.ArrayList;
import java.util.List;

public class q1592 {
    public static void main(String[] args) {
        String a = " practice   makes   perfect";
        System.out.println(reorderSpaces(a));
    }
    public static String reorderSpaces(String text) {
        String secquence = "                             ";
        List<String> strs = new ArrayList<>();
        int bNums = 0;
        for(int i = 0; i < text.length(); ) {
            StringBuilder sb = new StringBuilder();
            while(i < text.length() && text.charAt(i) != ' '){
                sb.append(text.charAt(i));
                i++;
            }
            if(sb.length() != 0){
                strs.add(sb.toString());
            }
            while(i < text.length() && text.charAt(i) == ' '){
                bNums ++;
                i ++;
            }
        }
        if(strs.size() == 1 && bNums == 0){
            return strs.get(0);
        }else if(strs.size() == 1 && bNums != 0){
            return strs.get(0) +  secquence.substring(0, bNums);
        }
        return String.join(secquence.substring(0, bNums/(strs.size() - 1)), strs) + secquence.substring(0, bNums%(strs.size() - 1));
    }
}
