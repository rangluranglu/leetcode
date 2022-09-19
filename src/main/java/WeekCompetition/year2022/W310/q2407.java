package WeekCompetition.year2022.W310;

public class q2407 {
    public int lengthOfLIS(int[] nums, int k) {
        // 线段树
        int[] max;
        int u = 0;
        for(int x : nums){
            int startIdx = Math.max(x - k, 0);
            int res = 1 + query(root, 0, N, startIdx, x - 1);
            update(root, 0, N, x, x, res);
        }

        return query(root, 1, N, 1, N);
    }

    class Node{
        Node left, right;
        int val, add;
    }
    private int N = (int)1e9;
    private Node root = new Node();

    public int query(Node node, int start, int end, int l, int r){
        if(l <= start && end <= r){
            return node.val;
        }

        int mid = start + (end - start) / 2, ans = 0;
        pushDown(node);

        if(l <= mid){
            ans = query(node.left, start, mid, l, r);
        }

        if(r > mid){
            ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        }

        return ans;
    }

    public void update(Node node, int start, int end, int l, int r, int val){
        if(l <= start && end <= r){
            node.val = val;
            node.add = val;
            return;
        }

        pushDown(node);
        int mid = start + (end - start) / 2;
        if(l <= mid){
            update(node.left, start, mid, l, r, val);
        }

        if(r > mid){
            update(node.right, mid + 1, end, l, r, val);
        }

        pushUp(node);
    }

    public void pushUp(Node node){
        node.val = Math.max(node.left.val, node.right.val);
    }

    public void pushDown(Node node){
        if(node.left == null){
            node.left = new Node();
        }
        if(node.right == null){
            node.right = new Node();
        }
        if(node.add == 0){
            return;
        }

        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;

        node.add = 0;
    }
}
