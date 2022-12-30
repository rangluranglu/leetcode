package Year2022.Week.DW93;

public class q2496 {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for(String str : strs){
            boolean isNum = true;
            int curNum = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(Character.isDigit(ch)){
                    curNum = curNum * 10 + ch - '0';
                }else {
                    curNum = str.length();
                    break;
                }
            }

            ans = Math.max(ans, curNum);
        }

        return ans;
    }

    public int maximumValue2(String[] strs) {
        int ans = 0;
        for(String str : strs){
            try {
                ans = Math.max(Integer.valueOf(str), ans);
            }catch (Exception e){
                ans = Math.max(str.length(), ans);
            }
        }

        return ans;
    }
}
