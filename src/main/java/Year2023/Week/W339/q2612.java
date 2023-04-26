package Year2023.Week.W339;

import netscape.security.UserTarget;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class q2612 {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        // [L, R] 的下标i 反转后 L + R - i
        // 滑动窗口
        // 向右滑动，翻转后 L 和 R 都增加 1
        // 向左滑动，翻转后 L 和 R 都减少 1
        // 因此，第一步可能 ，i 翻转后的所有位置组成了一个公差为 2 的等差数列（不考虑 banned）。

        // 不考虑数组边界， 范围是 [i - k + 1, i + k - 1]。
        //  i 在数组左边界 0 附近， 翻转受到左边界约束， L = 0, R = k - 1， 翻转后 0 + (k - 1) - i = k - i -1
        // 所以小于 k - i - 1 的点无法翻转

        // 数组右边界n - 1,  L = n - k, R = n - 1,  i翻转后 (n -k) + (n - 1) - i = 2n -k -i - 1
        // 大于 2n - k - i - 1 的点无法翻转

        // 实际范围 [max(i - k + 1, k - i - 1), min(i + k - 1, 2n - k - i - 1)]
        // 去掉已访问的操作
        // 1. 用平衡树 --> 维护下标，删除
            // 两个平衡树 分别维护奇数，另一个维护偶数
        // 2. 并查集， 只有删除操作
        // bfs 模拟
        boolean[] ban = new boolean[n];
        ban[p] = true;
        for(int i : banned){
            ban[i] = true;
        }

        TreeSet<Integer>[] sets = new TreeSet[2];

        // 分别记录 奇数下标和偶数下标
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();

        for(int i = 0; i < n; i++){
            if(!ban[i]){
                sets[i % 2].add(i);
            }
        }

        sets[0].add(n);
        sets[1].add(n);

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        List<Integer> q = new ArrayList<>();
        q.add(p);

        for(int step = 0; !q.isEmpty(); step ++){
            // bfs
            List<Integer> tmp = q;
            q = new ArrayList<>();

            for(int i : tmp){
                ans[i] = step;

                // 下一层
                int mn = Math.max(i - k + 1, k - i - 1);
                int mx = Math.min(i + k - 1, n * 2 -k - i - 1);

                TreeSet<Integer> s = sets[mn % 2];
                for(int j = s.ceiling(mn); j <= mx; j = s.ceiling(mn)){
                    q.add(j);
                    s.remove(j);
                }
            }

        }
        return ans;
    }


    int[] fa;
    public int[] minReverseOperations2(int n, int p, int[] banned, int k) {

        // 两个平衡树 分别维护奇数，另一个维护偶数
        // 2. 并查集， 只有删除操作
        // 删除一个元素，把它的下标j和j+1 合并， 这样后面删除的时候就会跳过已删除元素

        // [0 , n+1]
        fa = IntStream.range(0, n + 2).toArray();
        Set<Integer> ban = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        IntStream.range(0, n).filter(ban::contains).forEach(this::union);

        System.out.println(Arrays.toString(fa));

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(p);
        ans[p] = 0;
        union(p);

        // bfs
        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                // 取出
                int cur = queue.poll();
                int mn = Math.max(i - k + 1, k - i - 1);
                int mx = Math.min(i + k - 1, n * 2 -k - i - 1);

                for(int point = find(mn); point <= mx; point = find(point)){
                    ans[point] = ans[cur] + 1;
                    union(point);
                    queue.offer(point);
                }
            }
        }
        return ans;


    }

    public void union(int x){
        int a = find(x);
        int b = find(x + 2);

        if(a == b){
            return;
        }
        fa[a] = b;
    }

    public int find(int x){
        if(fa[x] != x){
            fa[x] = find(fa[x]);
        }

        return fa[x];
    }
}
