package Year2023.Daily.M5.D4;

public class q2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // 滑动窗口  [left, right]
        // startPos > right 移动 startPos - left 步
        // startPos < left 移动 right - startPos
        // left <= startPos <= right
            // 先向左 startPos - left + right - left
            // 先向右 right - startPos + right - left
            // 合并 right - left + min(right - startPos, startPos - left)

        // step(left, right) 从起点 startPos 出发可以覆盖区间 [left,right] 的最少移动步数
        // step(left, right) = right - left + min(|right - startPos|, |startPos - left|)
        // step(left - 1, right) >= step(left, right)


        int left = 0, right = 0;
        int n = fruits.length;
        int sum = 0, ans = 0;

        // 固定右边界
        while(right < 0){
            sum += fruits[right][1];

            // 移动左边界
            while (left <= right && step(fruits, startPos, left, right) > k){
                sum -= fruits[left][1];
                left ++;
            }

            ans = Math.max(ans, sum);
            right ++;
        }
        return ans;
    }

    private int step(int[][] fruits, int startPos, int left, int right){

        return Math.min(Math.abs(startPos - fruits[right][0]), Math.abs(startPos - fruits[left][0])) + fruits[right][0] - fruits[left][0];
    }
}
