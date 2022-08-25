package question;

import java.util.Arrays;

public class q179 {
    public String largestNumber(int[] nums) {
        // 排序
        int n = nums.length;
        String[] numStr = new String[n];
        for (int i = 0; i < n; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));
        if(numStr[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String num : numStr){
            sb.append(num);
        }

        return sb.toString();
    }
}
