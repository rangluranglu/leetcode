package Year2023.Week.W337;

public class q2595 {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];

        int index = 0;
        while (n != 0){
            if((n & 1) == 1){
                if(index % 2 == 0){
                    ans[0] ++;
                }else{
                    ans[1] ++;
                }
            }

            n >>= 1;
            index ++;
        }

        return ans;
    }
}
