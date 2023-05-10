package Year2023.Week.DW98;

import java.util.ArrayList;
import java.util.List;

public class q2569 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        // 线段树 重要
        // 维护1的个数

        int n = nums1.length;
        List<Long> ans = new ArrayList<>();
        long sum = 0;

        for(int x : nums2){
            sum += x;
        }

        SegmentTree t = new SegmentTree(nums1);

        for(int[] q : queries){
            if(q[0] == 1){
                t.update(q[1], q[2]);
            }else if(q[0] == 2){
                sum += (long) q[1] * t.sum();
            }else {
                ans.add(sum);
            }
        }

        return ans.stream().mapToLong(Long::valueOf).toArray();
    }

}

class SegmentTree{
    static class Node{
        Node left, right;
        int val;
        boolean lazy;
    }

    private Node root;
    private int n;
    public SegmentTree(int[] nums){
        this.n = nums.length;
        this.root = new Node();
        build(root, 1, n, nums);
    }

    public int sum(){
        return root.val;
    }

    private void build(Node node, int start, int end, int[] nums){
        if(start == end){
            node.val = nums[start - 1];
            return;
        }

        if(node.left == null){
            node.left = new Node();
        }

        if(node.right == null){
            node.right = new Node();
        }
        int mid = (start + end) >> 1;
        build(node.left, start, mid, nums);
        build(node.right, mid + 1, end, nums);
        pushUp(node);
    }

    public void update(int l, int r){
        update(root, 1, n, l + 1, r + 1);
    }

    public void update(Node node, int start, int end, int l, int r){
        // 在 [start, end] --> 更新[l,r], [l, r] 翻转

        if(l <= start && end <= r){
            // 更新值， 翻转
            node.val = (end - start + 1) - node.val;
            node.lazy = !node.lazy;
            return;
        }

        int mid = (start + end) >> 1;
        pushDown(node,mid - start + 1, end - mid);
        if(l <= mid){
            update(node.left, start, mid, l, r);
        }
        if(r > mid){
            update(node.right, mid + 1, end, l, r);
        }
        pushUp(node);
    }

    public int query(Node node, int start, int end, int l, int r){
        if(l <= start && end <= r){
            return node.val;
        }

        int mid = (start + end) >> 1, ans = 0;

        if(l <= mid){
            ans += query(node.left, start, mid, l, r);
        }

        if(r > mid){
            ans += query(node.right, mid + 1, end, l, r);
        }
        return ans;
    }

    // 1的个数
    private void pushUp(Node node){
        node.val = node.left.val + node.right.val;
    }

    private void pushDown(Node node, int leftNum, int rightNum){
        if(node.left == null){
            node.left = new Node();
        }

        if(node.right == null){
            node.right = new Node();
        }

        if(!node.lazy){
            return;
        }

        node.left.val = leftNum - node.left.val;
        node.right.val = rightNum - node.right.val;

        node.left.lazy = !node.left.lazy;
        node.right.lazy = !node.right.lazy;

        node.lazy = false;
    }

}
