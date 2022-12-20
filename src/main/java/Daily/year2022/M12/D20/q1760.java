package Daily.year2022.M12.D20;

import java.util.Arrays;

public class q1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        // 最后分成  maxOperations + n 个袋子
        // 平均， 最大值的最小值。

        // 二分查找
        // 对答案进行二分查找

        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;

        while (left <= right){
            int y = (left + right) / 2;

            long ops = 0;

            for(int x : nums){
                // 向下取整
                // x <= y 时 无需操作
                // y < x <= 2y 时， 进行1次操作
                // 2y < x <= 3y 时， 进行2次操作
                ops += (x - 1) / y;
            }

            if(ops <= maxOperations){
                ans = y;
                right = y - 1;
            }else {
                left = y + 1;
            }
        }

        return ans;

    }
}
