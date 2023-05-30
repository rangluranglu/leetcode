package Year2023.Week.W346;

public class q2697 {
    public String makeSmallestPalindrome(String s) {
        // 替换， 尽可能少的操作

        char[] chars = s.toCharArray();

        int i = 0, j = chars.length -1;

        while (i < j){
            if(chars[i] < chars[j]){
                chars[j] = chars[i];
            }else if(chars[i] > chars[j]){
                chars[i] = chars[j];
            }

            i ++;
            j --;
        }

        return new String(chars);
    }
}
