package Daily.year2022.M9.D19;

import java.util.Arrays;

public class q1636 {
    public int[] frequencySort(int[] nums) {
        // 频率升序
        int [] count = new int[201];
        Integer [] idx = new Integer[201];

        for(int num : nums){
            count[num + 100] ++;
        }
        for(int i  = 0; i < 201; i++){
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> count[i] == count[j] ? j - i : count[i] - count[j]);
        int[] ans = new int[nums.length];
        int k = 0;
        for(int i = 0; i < 201; i++){
            int index = idx[i];
            if(count[index] != 0){
                for(int j = 0; j < count[index]; j++){
                    ans[k] = index - 100;
                    k ++;
                }
            }
        }

        return ans;
    }
}
