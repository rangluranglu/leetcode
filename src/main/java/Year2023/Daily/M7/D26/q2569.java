package Year2023.Daily.M7.D26;

public class q2569 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        // 线段树

    }

}


// 线段树

class SegmentTree{
    class Node{
        Node left, right;
        int val;
        boolean lazy;
    }


    private Node root;
    private int n;

    public SegmentTree(int[] nums){
        // 初始化
        this.n = nums.length;
        this.root = new Node();
        build(root, 1, n, nums);
    }

    private void build(Node node, int start, int end, int[] nums){
        if(start == end){
            node.val = nums
        }
    }
}