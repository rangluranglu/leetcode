package Year2023.Week.W358;

import Common.ListNode;

public class q6914 {
    int add = 0, ans = 0;
    public ListNode doubleIt(ListNode head) {
        dfs(head);

        if(add > 0){
            return new ListNode(add, head);
        }

        return head;
    }

    private void dfs(ListNode node){
        if(node == null){
            return ;
        }

        dfs(node.next);

        int val = node.val * 2 + add;
        add = val / 10;
        node.val = val % 10;
    }
}
