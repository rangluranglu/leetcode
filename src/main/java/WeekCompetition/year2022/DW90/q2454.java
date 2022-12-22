package WeekCompetition.year2022.DW90;

import java.util.Arrays;

public class q2454 {
    private static int[] s = new int[100000], t = new int[100000];
    public int[] secondGreaterElement(int[] nums) {
        // 单调栈 --> 递减
        // 双单调栈
        // 用数组模拟栈
        int n = nums.length;
        int p = 0, q = 0;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            // 已经有第一大元素的 数会在这个栈中
            while (q > 0 && nums[t[q - 1]] < x){
                ans[t[--q]] = x;
            }

            int pp = p;

            // x 是栈顶右侧第一大
            while (p > 0 && nums[s[p - 1]] < x){
                p --;
            }
            // 将栈s从p位置开始拷贝`pp-p`个元素到栈t的q下标。这里相当于s弹出的元素都添加到了t的栈顶,因为这部分元素遇到了右侧第一大的数x，
            // 现在转移到t第二栈，当这部分元素在t中遇到更大的数，这个更大的数就是这部分元素的右侧第二大数。
            System.arraycopy(s, p, t, q, pp - p);

            q += pp - p;
            s[p++] = i;
        }

        return ans;
    }
}
