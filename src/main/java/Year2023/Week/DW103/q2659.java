package Year2023.Week.DW103;

import java.util.Arrays;

public class q2659 {
    public long countOperationsToEmptyArray(int[] nums) {
        // 不断循环使数组递增
        // 计算 不能 模拟

        // 树状数组

        int n = nums.length;
        Integer[] id = new Integer[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

        Arrays.sort(id, (i, j) ->nums[i] - nums[j]);

        long ans = n;
        BIT t = new BIT(n + 1);

        int pre = 1;
        for(int k = 0; k < n; k++){
            // 下标从1开始
            int i = id[k] + 1;

            if(i >= pre){
                // 跳过已经删除的数
                ans += i - pre - t.query(pre, i);
            }else {
                // pre 移动到n, 再从k 移动到i，跳过删除
                // (n - pre - query(pre,n)) + (i - qurey(1, i))
                // k 个数已经删除， query(pre, n) + query(1, i) = k - query(i + 1, pre -1) = k - query(i, pre -1)
                // 化简为 i - pre + n - k + query(i, pre -1)
                ans += n - pre + i - k + t.query(i, pre -1);
            }

            t.inc(i);
            pre = i;
        }

        return ans;


    }

    public long countOperationsToEmptyArray2(int[] nums) {
        // 不断循环使数组递增
        int n = nums.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

        Arrays.sort(id, (i, j) -> nums[i] - nums[j]);

        long ans = n;
        for(int k = 1; k < n; k++){
            if(id[k] < id[k - 1]){
                // 必须多走一圈
                ans += n - k;
            }
        }

        return ans;
    }
}
// 树状数组模板
class BIT{
    private final int[] tree;

    // tree[x] 保存以x为根的子树中叶节点值的和
    // tree[x] 节点覆盖的长度就是 lowBit(x)
    // tree[x] 节点的父节点为 tree[x + lowBit(x)]


    public BIT(int n){
        tree = new int[n];
    }


    // 将下标i上的数 +1
    // O(log n)
    public void inc(int i){
        while (i < tree.length){
            tree[i] ++;

            // 找到父节点
            i += i & -i;
        }
    }

    // 返回闭区间[1, i] 的元素和
    public int sum(int x){
        int res = 0;
        while (x > 0){
            res += tree[x];
            // 找左上角节点
            x &= x - 1;
        }

        return res;
    }

    // 返回闭区间[left, right] 的元素和
    public int query(int left, int right){
        return sum(right) - sum(left - 1);
    }
}

