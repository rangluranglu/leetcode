package question;

public class q138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        // O(1) 的 方法将新节点插入旧节点后
        if(head == null){
            return null;
        }
        Node p = head;

        // 复制节点
        while (p != null){
            // 保存next
            Node next = p.next;
            Node newP = new Node(p.val);

            p.next = newP;
            newP.next = next;

            p = next;
        }

        // 连接指针
        p = head;
        while (p != null){
            // 连接指针
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        // 断开连接
        Node newHead = head.next;
        p = head;
        while (p != null){
            Node next = p.next;

            p.next = next.next;
            next.next = next.next == null ? null : next.next.next;

            p = p.next;
        }

        return newHead;



    }
}
