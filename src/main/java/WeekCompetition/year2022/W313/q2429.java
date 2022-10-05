package WeekCompetition.year2022.W313;

public class q2429 {
    public int minimizeXor(int num1, int num2) {
        int count_num2 = Integer.bitCount(num2);
        int count_num1 = Integer.bitCount(num1);
        //System.out.println(count_num1 + "---" + count_num2);

        if(count_num1 == count_num2){
            return num1;
        }
        if(count_num1 < count_num2){
            int a = count_num2 - count_num1;
            int map = 1;
            int ans = num1;
            while (a != 0){
                if((num1 & map) != 0){
                    map <<= 1;
                }else {
                    ans |= map;
                    map <<= 1;
                    a --;
                }
            }

            return ans;
        }
        if(count_num2 < count_num1){
            int a = count_num1 - count_num2;
            int ans = num1;
            while (a != 0){
                // 取出左边的a个1
                ans &= (ans - 1);
                a --;
            }
            return ans;
        }
        return 0;
    }

    public int minimizeXor2(int num1, int num2) {
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);

        for(; c2 < c1; c2++){
            num1 &= num1 - 1;
        }

        for (; c2 > c1; c2--){
            num1 |= num1 + 1;
        }

        return num1;
    }



}
