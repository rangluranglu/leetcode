package Year2022.Week.DW91;

public class q2468 {
    public String[] splitMessage(String message, int limit) {
        // limit - 3
        // 设message 的长度是n 。 枚举分割个数i， 不断增大容量cap， 直到 cap >= n;

        int n = message.length();
        // cap 是指在 i 长度下，能收纳字符的长度
        for(int i = 1, cap = 0, tail_len; ; i++){
            if(i < 10){
                tail_len = 5;
            }else if(i < 100){
                if(i == 10){
                    cap -= 9;
                }
                tail_len = 7;
            }else if(i < 1000){
                if(i == 100){
                    cap -= 99;
                }
                tail_len = 9;
            }else {
                if(i == 1000){
                    cap -= 999;
                }

                tail_len = 11;
            }

            if(tail_len >= limit){
                return new String[]{};
            }

            cap += limit - tail_len;
            if(cap < n){
                continue;
            }

            // 容量达到了
            String[] ans = new String[i];
            for(int j = 0, k = 0; j < i; j++){
                String tail = "<" + (j + 1) + "/"+ i + ">";
                if(j == i - 1){
                    ans[j] = message.substring(k) + tail;
                }else {
                    int m = limit - tail.length();
                    ans[j] = message.substring(k, k + m) + tail;
                    k += m;
                }
            }

            return ans;
        }


    }
}
