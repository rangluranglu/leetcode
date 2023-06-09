package Year2023.Week.W348;

public class q2716 {
    public int minimizedStringLength(String s) {
        // length < 100
        // 不同字符的数目

        int mask = 0;

        for(char c : s.toCharArray()){
            mask |= 1 << (c - 'a');
        }

        return Integer.bitCount(mask);
    }
}
