package Year2022.Daily.M10.D31;

public class q481 {
    public int magicalString(int n) {
        if(n < 4){
            return 1;
        }

        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2, j = 3;

        while (j < n){
            // 需要的长度
            int length = s[i] - '0';
            // 下一个数字
            int num = 3 - (s[j - 1] - '0');
            // 填充数字
            while (j < n && length > 0){
                s[j] = (char) ('0' + num);
                if(num == 1){
                    res ++;
                }

                j ++;
                length --;
            }
            i++;
        }

        return res;

    }
}
