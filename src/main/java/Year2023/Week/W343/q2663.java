package Year2023.Week.W343;

public class q2663 {
    public String smallestBeautifulString(String s, int k) {
        // 不包含回文， 不能出现 s[i] == s[i - 1] and s[i] == s[i - 2]
        // 字符串最小，修改的位置越靠右越好
        // 前提： s是美丽串
        k += 'a';

        char[] chars = s.toCharArray();
        int n = s.length(), i = n - 1;

        chars[i] ++;  // 从最后一个字母

        while (i < n){
            if(chars[i] == k){
                // 超过范围

                if(i == 0){
                    return ""; // 无法进位
                }

                // 进位
                chars[i] = 'a';
                ++chars[--i];
            }else if(i > 0 && chars[i] == chars[i - 1] || i > 1 && chars[i] == chars[i - 2]){
                chars[i]++;
            }else{
                i++;
            }
        }
        return new String(chars);
    }
}
