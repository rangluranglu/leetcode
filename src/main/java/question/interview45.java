package question;

import java.util.Arrays;

public class interview45 {
    public String minNumber(int[] nums) {
        String[] num = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            num[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(num, (a,b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();

        for(String n : num){
            sb.append(n);
        }

        return sb.toString();
    }
}
