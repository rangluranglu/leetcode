package Year2023.Daily;


import javafx.util.Pair;

public class Solution {

    public static void main(String[] args) {
        Node head = buildList(new int[]{1,2,3,4,5,6,7,8});
        Node node = reverseListNodeByK(head, 3);
        printList(node);
    }

    public static void printList(Node node){
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static Node buildList(int[] list){
        Node head = new Node(-1, null);
        Node dummy = head;
        for(int l : list){
            head.next = new Node(l, null);
            head = head.next;
        }
        return dummy.next;

    }

    public static Node reverseListNodeByK(Node head, int k){
        if(head == null){
            return head;
        }

        Node dummy = new Node(-1, head);
        Node cur = dummy;

        while (head != null){
            Node tail = cur;
            // 找到一组
            for(int i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null){
                    return dummy.next;
                }
            }

            Node next = tail.next;
            // reverse
            Node[] reverse = reverse(head, tail);
            // 翻转完成，拼接
            head = reverse[0];
            tail = reverse[1];

            cur.next = head;
            tail.next = next;

            cur = tail;
            head = tail.next;
        }

        return dummy.next;
    }

    public static Node[] reverse(Node head, Node tail){
        Node prev = tail.next;
        Node cur = head;

        while(prev != tail){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return new Node[]{tail, head};
    }

    public static Node reverseListNode(Node head){
        if(head == null){
            return head;
        }

        Node cur = head, prev = null;
        while(cur != null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

}

class Node{
    Node next;
    int val;


    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}
