package Year2022.Daily.M9.D23;

public class q707 {
}
class MyLinkedList {
    // 内部节点类
    class Node{
        Node prev;
        Node next;
        int val;

        public Node(int val){
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= size){
            return -1;
        }
        Node dumy = head;
        while (index-- >= 0){
            dumy = dumy.next;
        }

        return dumy.val;
    }

    public void addAtHead(int val) {
        Node next = head.next;
        Node node = new Node(val);
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;

        size ++;
    }

    public void addAtTail(int val) {
        Node prev = tail.prev;
        Node node = new Node(val);

        tail.prev = node;
        node.next = tail;
        node.prev = prev;
        prev.next = node;

        size ++;

    }

    public void addAtIndex(int index, int val) {
        // 这里需要特殊处理
        if(index >= size + 1){
            return;
        }

        Node dumy = head;
        while (index-- >= 1){
            dumy = dumy.next;
        }
        Node node = new Node(val);
        Node next = dumy.next;

        dumy.next = node;
        node.prev = dumy;
        node.next = next;
        next.prev = node;

        size += 1;
    }

    public void deleteAtIndex(int index) {
        if (index >= size){
            return ;
        }

        Node dumy = head;
        while (index-- >= 1){
            dumy = dumy.next;
        }

        Node next = dumy.next.next;

        dumy.next = next;
        next.prev = dumy;

        size--;
    }
}