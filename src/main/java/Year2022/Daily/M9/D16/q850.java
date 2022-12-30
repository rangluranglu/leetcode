package Year2022.Daily.M9.D16;

import java.util.*;

public class q850 {
    int MOD = (int) 1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        // 扫描线
        int n = rectangles.length;

        Set<Integer> set = new HashSet<>();
        for(int[] rectangele : rectangles){
            set.add(rectangele[1]);
            set.add(rectangele[3]);
        }

        // 上下边界
        List<Integer> hbound = new ArrayList<>(set);
        Collections.sort(hbound);

        int m = hbound.size();

        int[] seg = new int[m - 1];

        List<int[]> sweep = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sweep.add(new int[]{rectangles[i][0], i, 1});

            sweep.add(new int[]{rectangles[i][2], i, -1});
        }

        Collections.sort(sweep, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else if(a[1] != b[1]){
                return a[1] - b[1];
            }else {
                return a[2] - b[2];
            }
        });


        long ans = 0;
        // 扫描开始
        for (int i = 0; i < sweep.size(); i++) {
            int j = i;
            while(j + 1 < sweep.size() && sweep.get(i)[0] == sweep.get(j + 1)[0]){
                // 跳过横坐标
                j ++;
            }

            if(j + 1 == sweep.size()){
                break;
            }

            // 一次性处理横坐标相同的左右边界
            for(int k = i; k <= j; k++){
                int[] arr = sweep.get(k);
                int idx = arr[1], diff = arr[2];
                // 上下 边界
                int bottom = rectangles[idx][1], top = rectangles[idx][3];
                for(int x = 0; x < m - 1; x++){
                    if(bottom <= hbound.get(x) && hbound.get(x + 1) <= top){
                        seg[x] += diff;
                    }
                }
            }

            int cover = 0;
            for(int k = 0; k < m - 1; k++){
                if(seg[k] > 0){
                    cover += (hbound.get(k + 1) - hbound.get(k));
                }
            }
            ans += (long) cover * (sweep.get(j + 1)[0] - sweep.get(j)[0]);
            i = j;
        }

        return (int) (ans % MOD);
    }

    private Node[] tree;
    public int rectangleArea2(int[][] rectangles) {
        // 线段树 离散化
        int n = rectangles.length;

        Set<Integer> set = new HashSet<>();
        for(int[] rectangele : rectangles){
            // 上边界
            set.add(rectangele[1]);
            // 下边界
            set.add(rectangele[3]);
        }

        // 上下边界
        List<Integer> hbound = new ArrayList<>(set);
        Collections.sort(hbound);
        int m = hbound.size();
        // 线段树有 m-1 个叶子节点，对应着 m-1 个会被完整覆盖的线段，需要开辟 ~4m 大小的空间
        tree = new Node[m * 4 + 1];
        // TODO
        return 0;
    }

    // 线段树节点
    class Node{
        Node left, right;
        int val;
        int add;
    }


    private void pushDown(Node node, int leftNum, int rightNum){
        // 下推标记
        if(node.left == null){
            node.left = new Node();
        }
        if(node.right == null){
            node.right = new Node();
        }

        // 没有标记
        if(node.add == 0){
            return;
        }

        // 计算值
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;

        // 标记下推
        node.left.add += node.add;
        node.right.add += node.add;

        // 取消当前标记
        node.add = 0;
    }

    // 更新函数
    private void update(Node node, int start, int end, int l, int r, int val){
        if(l <= start && end <= r){
            // 区间节点加上更新值
            node.val += (end - start + 1) * val;
            node.add += val;
            return;
        }

        int mid = (start + end) >> 1;
        // 下推标记
        // mid-start + 1 左子区间数量
        pushDown(node, mid - start + 1, end - mid);

        if(l <= mid){
            update(node.left, start, mid, l, r, val);
        }

        if(r > mid){
            update(node.right, mid + 1, end, l, r, val);
        }

        pushUp(node);
    }

    private int query(Node node, int start, int end, int l, int r){
        if(l <= start && end <= r){
            return node.val;
        }

        int mid = (start + end) >> 1, ans = 0;
        pushDown(node, mid - start + 1, end - mid);

        if(l <= mid){
            ans += query(node.left, start, mid, l, r);
        }

        if(r > mid){
            ans += query(node.right, mid + 1, end, l, r);
        }

        return ans;
    }

    private void pushUp(Node node){
        node.val = node.left.val + node.right.val;
    }
}
