package question;

import java.util.ArrayList;
import java.util.List;

public class q729 {
    class MyCalendar {
        List<int[]> calendar;
        public MyCalendar() {
            calendar = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for(int arr[] : calendar){
                if((start >= arr[0] && start < arr[1]) || (end > arr[0] && end <= arr[1]) || (arr[0] >= start && arr[1] <= end)){
                    //System.out.println("start" + start + "end" + end);
                    //System.out.println("start" + arr[0] + "end" + arr[1]);
                    return false;
                }
            }

            calendar.add(new int[]{start, end});
            return true;
        }
    }

    class MyCalendar2 {
        public MyCalendar2() {
        }

        public boolean book(int start, int end) {
            if(query(root, 0, N, start, end - 1) != 0){
                return false;
            }
            update(root, 0, N, start, end - 1, 1);
            return true;
        }
    }

    class Node{
        Node left, right;
        int val, add;
    }
    int N = (int) 1e9;
    private Node root = new Node();

    // 区间最值
    public void pushDown(Node node){
        if(node.left == null){
            node.left = new Node();
        }
        if(node.right == null){
            node.right = new Node();
        }

        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    public void pushUp(Node node){
        node.val = Math.max(node.left.val, node.right.val);
    }

    public void update(Node node, int start, int end, int l, int r, int val){
        if(l <= start && end <= r){
            node.val += val;
            node.add += val;
            return;
        }

        pushDown(node);
        int mid = (start + end) >> 1;
        if(l <= mid){
            update(node.left, start, mid, l, r, val);
        }

        if(r > mid){
            update(node.right, mid + 1, end, l, r, val);
        }

        pushUp(node);
    }

    public int query(Node node, int start, int end, int l, int r){
        if(l <= start && end <= r){
            return node.val;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        int ans = 0;
        if(l <= mid){
           ans = query(node.left, start, mid, l, r);
        }

        if(r > mid){
            ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        }

        return ans;
    }
}
