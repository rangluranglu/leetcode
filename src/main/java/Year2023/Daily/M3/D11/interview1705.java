package Year2023.Daily.M3.D11;

import java.util.HashMap;
import java.util.Map;

public class interview1705 {
    public String[] findLongestSubarray(String[] array) {
        // 子数组：字母和数字相同 --> 子数组中数字个数和字母个数 差值为0

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        // 记录结果
        int maxLength = 0;
        int startIndex = -1;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            if(Character.isLetter(array[i].charAt(0))){
                // 是字符
                sum ++;
            }else {
                sum --;
            }

            if(map.containsKey(sum)){
                // 有相同的和
                int firstIndex = map.get(sum);
                if(i - firstIndex > maxLength){
                    maxLength = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            }else {
                map.put(sum, i);
            }
        }


        if(maxLength == 0){
            return new String[0];
        }

        String[] ans = new String[maxLength];
        System.arraycopy(array, startIndex, ans, 0, maxLength);

        return ans;
    }
}
