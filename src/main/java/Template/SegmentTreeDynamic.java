package Template;

public class SegmentTreeDynamic {
    // 线段树解决区间和的问题，求区间和 -- 修改区间 O(log n)
    // 线段树每个节点代表一个区间， 节点的值是改区间的和（可以有别的定义）

    class Node{

        // 左右孩子节点
        Node left, right;

        // 节点值
        int val;

        // 懒惰标记
        int add;
    }

    int N = (int) 1e9;
    private Node root = new Node();


    // 更新区间
    // 在区间[start, end] 更新 [l, r] 的值， [l, r] + val
    public void update(Node node, int start, int end, int l, int r, int val){
        // 找到满足要求的区间
        if(l <= start && end <= r){
            node.val += (end - start + 1) * val;
            node.add += val;
            return;
        }

        int mid = (start + end) >> 1;

        // 下推标记
        // 左孩子数量 ： mid - start + 1
        // 右孩子数量： end - mid
        pushDown(node, mid - start + 1, end - mid);

        // [start, mid] 和 [l, r] 有交集， 遍历
        if(l <= mid){
            update(node.left, start, mid, l, r, val);
        }

        if(r > mid){
            update(node.right, mid + 1, end, l, r, val);
        }

        // 上推
        pushUp(node);
    }


    public void pushDown(Node node, int leftNum, int rightNum){
        // 动态开点
        if(node.left == null){
            node.left = new Node();
        }

        if(node.right == null){
            node.right = new Node();
        }

        if(node.add == 0) return;

        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;

        node.left.add += node.add;
        node.right.add += node.add;

        node.add = 0;
    }

    public void pushUp(Node node){
        node.val = node.left.val + node.right.val;
    }

    // 查询
    public int query(Node node, int start, int end, int l, int r){
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
}
