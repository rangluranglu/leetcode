package question;

public class offer56 {
    // 那么各个二进制位为1的个数 % 3 便能求出这个数哪些位置为1， 最后再将其转换为十进制
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            while(nums[i] > 0){
                bits[j] += nums[i] % 2;
                nums[i] /= 2;
                j ++;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (bits[31 - i] % 3);
        }

        return ans;
    }

}
