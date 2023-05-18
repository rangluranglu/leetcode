package Year2023.Daily.M5.D18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        // 负二进制
        // carray {-1, 0}, arr[i] = {0, 1}

        // x = 0, 1 --> carry 为0，
        // x = 2, i位结果是 x - 2,  carry = -1
        // x = -1, i位为1， 高位进1

        int i = arr1.length - 1, j = arr2.length - 1;
        List<Integer> ans = new ArrayList<>();

        for(int c = 0; i >= 0 || j >= 0 || c != 0; i--, j--){
            int a = i < 0 ? 0 : arr1[i];
            int b = j < 0 ? 0 : arr2[i];

            int x = a + b + c;
            c = 0;

            if (x >= 2){
                x -= 2;
                c -= 1;
            }else if(x == -1){
                x = 1;
                c += 1;
            }


            ans.add(x);
        }

        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0){
            ans.remove(ans.size() - 1);
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
