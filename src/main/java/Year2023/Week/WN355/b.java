package Year2023.Week.WN355;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class b {
    public long maxArrayValue(int[] nums) {
        // 将前一个小的数 加给后一个大的数
        // 递增数组
        if(nums.length == 1){
            return nums[0];
        }
        List<Long> list = Arrays.stream(nums).mapToLong(i -> (long) i).boxed().collect(Collectors.toList());
        return dfs(list);

    }

    public  long dfs(List<Long> nums){
        if(nums.size() == 1){
            return nums.get(0);
        }
        List<Long> sums = new ArrayList<>();

        long sum = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) >= nums.get(i - 1)){
                sum += nums.get(i);
            }else{
                sums.add(sum);
                sum = nums.get(i);
            }
        }
        sums.add(sum);

        System.out.println(sums);
        if (sums.size() == nums.size() || sums.size() == 1){
            return sums.get(0);
        }

        return dfs(sums);
    }

    // 递归
}
