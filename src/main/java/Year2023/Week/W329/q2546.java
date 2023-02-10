package Year2023.Week.W329;

public class q2546 {
    public boolean makeStringsEqual(String s, String target) {
        // 两个数字完全相等 0 1
        // 0 0 --> 0 0
        // 1 1 --> 1 0
        // 1 0 --> 1 1
        // 0 1 --> 1 1

        // 只能有一个不相等
        // 操作任意次
        if(s.length() != target.length()){
            return false;
        }

        // 只要有1
        return s.contains("1") == target.contains("1");
    }
}
