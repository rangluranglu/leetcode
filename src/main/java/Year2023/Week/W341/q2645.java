package Year2023.Week.W341;

public class q2645 {
    public int addMinimum(String word) {
        // 任意位置插入 a b c --> 有效的字符串
        // ab --> c, ac --> b, bc-->a

        // 找周期

        char[] s = word.toCharArray();

        // 如何初始化
        int ans = 1;

        for(int i = 1; i < s.length; i++){
            if(s[i] <= s[i - 1]){
                ans ++;
            }
        }

        return  ans * 3 - s.length;


    }
}
