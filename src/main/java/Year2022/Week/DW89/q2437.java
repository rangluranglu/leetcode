package Year2022.Week.DW89;

public class q2437 {
    public int countTime(String time) {
        if(time.indexOf("?") == -1){
            return 1;
        }

        int sum = 1;
        // 判断每个数，分类讨论
        if(time.charAt(0) == '?'){
            if(time.charAt(1) == '?'){
                sum *= 24;
            }else if(time.charAt(1) <= '3'){
                sum *= 3;
            }else {
                sum *= 2;
            }
        }else {
            if(time.charAt(1) == '?'){
                if(time.charAt(0) <= '1'){
                    sum *= 10;
                }else if(time.charAt(0) == '2'){
                    sum *= 4;
                }
            }
        }


        if(time.charAt(3) == '?'){
            if(time.charAt(4) == '?'){
                sum *= 60;
            }else {
                sum *= 6;
            }
        }else {
            if(time.charAt(4) == '?'){
                sum *= 10;
            }
        }

        return sum;

    }
}
