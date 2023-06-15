package Year2023.Week.DW101;

public class q2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        // 如果有相同数 那么就个位数 否则就最小值
        // 元素互不相同
        // 位运算

        int mask1 = 0, mask2 = 0;
        for(int x : nums1){
            mask1 |= 1 << x;
        }

        for(int x : nums2){
            mask2 |= 1 << x;
        }

        int m = mask1 & mask2;

        if(m != 0){
            return Integer.numberOfTrailingZeros(m);
        }

        int x = Integer.numberOfTrailingZeros(mask1);
        int y = Integer.numberOfTrailingZeros(mask2);

        return Math.min(x * 10 + y, 10 * y + x);

    }
}
