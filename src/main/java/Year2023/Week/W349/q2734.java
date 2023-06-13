package Year2023.Week.W349;

public class q2734 {
    public String smallestString(String s) {
        // 找到 两个a的位置
        char[] chars = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            if(chars[i] > 'a'){
                for(; i < s.length() && chars[i] > 'a'; i++){
                    chars[i] --;
                }

                return new String(chars);
            }
        }

        chars[s.length() - 1] = 'z';
        return new String(chars);
    }
}
