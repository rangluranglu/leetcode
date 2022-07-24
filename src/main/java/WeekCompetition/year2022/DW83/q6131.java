package WeekCompetition.year2022.DW83;

import java.util.HashSet;
import java.util.Set;

public class q6131 {
    public static void main(String[] args) {
        int[] rolls = {4,2,1,2,3,3,2,4,1};
        System.out.println(shortestSequence2(rolls, 4));
    }
    public int shortestSequence(int[] rolls, int k) {
        // 思路， 寻找出现k个数
        // 贪心
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for(int i  : rolls){
            set.add(i);
            if(set.size() == k){
                ans ++;
                set.clear();
            }
        }
        return ans;
    }

    public static int shortestSequence2(int[] rolls, int k) {
        int[] mark = new int[k + 1]; // mark[v] 标记 v 属于哪个子段
        int ans = 1, left = k;
        for (int v : rolls) {
            if (mark[v] < ans) {
                // 记录是在第几个子段当中
                mark[v] = ans;
                if (--left == 0) {
                    left = k;
                    ++ans;
                }
            }
        }
        return ans;
    }
}
