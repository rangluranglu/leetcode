package Year2023.Daily.M5.D11;

public class q1016 {
    public boolean queryString(String s, int n) {
        // 滑动窗口
        for (int i = 1; i <= n; i++) {
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }

        return true;
    }
}
