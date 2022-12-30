package Year2022.Daily.M9.D29;

public class interview0109 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.length() == 0){
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i) == s1.charAt(0)){
                if(s1.equals(s2.substring(i) + s2.substring(0, i))){
                    flag = true;
                }
            }
            if(flag){
                return true;
            }
        }

        return false;
    }

    public boolean isFlipedString2(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
