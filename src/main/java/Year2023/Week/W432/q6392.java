package Year2023.Week.W432;

public class q6392 {
    public int minOperations(int[] nums) {
        // nums 下标从0开始的正整数
        // 将 nums[i] 或 nums[i + 1] 之一替换为他们的最大公约数
        // --> 使所有元素变为1的最少操作次数

        // 找到公约数为1
        // 花费尽量少的操作得出一个1 --> 找到最短的GCD为1的子数组,长度为minSize
        // 需要操作 minSize - 1 次得到1

        // 答案为 (minSize - 1) + (n - 1) = minSize + n - 2;

        int n = nums.length, gcdAll = 0, cnt1 = 0;

        for(int x : nums){
            gcdAll = gcd(gcdAll, x);
            if(x == 1){
                cnt1 ++;
            }
        }

        if(gcdAll > 1){
            return -1;
        }

        if(cnt1 > 0){
            return n - cnt1;
        }

        int minSize = n;
        // 找到最小子数组

        for (int i = 0; i < n; i++) {
            int g = 0;

            for(int j = i; j < n; j++){
                g = gcd(g, nums[j]);
                if(g == 1){
                    // 这里是 j- i + 1, 把+1 提取合并到return中
                    minSize = Math.min(minSize, j - i);
                    break;
                }
            }
        }

        return minSize + n - 1;
    }

    private int gcd(int a, int b){

        while (a != 0){
            int tmp = a;
            a = b % a;
            b = tmp;
        }

        return b;
    }
}
