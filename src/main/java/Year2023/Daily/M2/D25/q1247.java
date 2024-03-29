package Year2023.Daily.M2.D25;

public class q1247 {
    public int minimumSwap(String s1, String s2) {
        // 1247.交换字符使得字符串相同

        // 贪心
        // 不相同 --> xy  和 yx

        int xy = 0, yx = 0;
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if(a == 'x' && b == 'y'){
                xy ++;
            }
            if(a == 'y' && b == 'x'){
                yx ++;
            }
        }

        if((xy + yx) % 2 == 1){
            return -1;
        }

        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}
