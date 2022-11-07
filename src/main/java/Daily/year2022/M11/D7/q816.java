package Daily.year2022.M11.D7;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class q816 {
    public static void main(String[] args) {
        String a = "(00011)";
        System.out.println(ambiguousCoordinates(a));
    }
    public static List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);

        List<String> ans = new ArrayList<>();

        // 分组
        int n = s.length();


        for (int l = 1; l < n; l++){

            List<String> lt = getPos(s.substring(0, l));
            if(lt.isEmpty()){
                continue;
            }

            List<String> rt = getPos(s.substring(l));
            if(rt.isEmpty()){
                continue;
            }

            for(String i : lt){
                for (String j : rt) {
                    ans.add("(" + i + ", " + j + ")");
                }
            }
        }
        return ans;
    }

    private static List<String> getPos(String s) {
        // 根据字符串生成可能的数字
        List<String> pos = new ArrayList<>();
        if(s.charAt(0) != '0' || "0".equals(s)){
            // 不加小数点
            pos.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            if((i != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0'){
                continue;
            }
            pos.add(s.substring(0, i) + "." + s.substring(i));
        }
        return pos;
    }
}
