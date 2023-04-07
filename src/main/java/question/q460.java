package question;

import java.util.HashMap;
import java.util.Map;

public class q460 {
}


class LFUCache {
    // 最不经常使用
    // 计数

    // Map + TreeMap  复杂度不满足要求
    // 双哈希表
    // freq_map --> freq 放 key, value
    // key_map --> key key, value  freq_map中的位置

    int minFreq, capacity;
    Map<Integer, Node> keyTable;
    Map<Integer, DoublyLinkedList> freqTable;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }


    // 要求o(1)
    public int get(int key) {

        if(capacity == 0){
            return -1;
        }

        if(!keyTable.containsKey(key)){
            return -1;
        }

        Node node = keyTable.get(key);
        int val = node.val, freq = node.freq;
        freqTable.get(freq).remove(node);

        if(freqTable.get(freq).size == 0){
            freqTable.remove(freq);

            if(minFreq == freq){
                minFreq ++;
            }
        }

        // 插入
        DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
        list.addFirst(new Node(key, val, freq + 1));
        freqTable.put(freq + 1, list);

        keyTable.put(key, freqTable.get(freq + 1).getHead());
        return val;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }

        if(!keyTable.containsKey(key)){
            // 新增
            if(keyTable.size() == capacity){
                // 通过 minFreq 拿到 freqTable[minFreq] 链表的末尾节点

                Node node = freqTable.get(minFreq).getTail();
                keyTable.remove(node.key);

                freqTable.get(minFreq).remove(node);
                if(freqTable.get(minFreq).size == 0){
                    freqTable.remove(minFreq);
                }

            }

            DoublyLinkedList list = freqTable.getOrDefault(1, new DoublyLinkedList());
            list.addFirst(new Node(key, value, 1));
            freqTable.put(1, list);
            keyTable.put(key, freqTable.get(1).getHead());

            minFreq = 1;
        }else {
            // 存在， 需要更新
            Node node = keyTable.get(key);
            int freq = node.freq;
            freqTable.get(freq).remove(node);

            if(freqTable.get(freq).size == 0){
                freqTable.remove(freq);
                if(minFreq == freq){
                    minFreq += 1;
                }
            }

            DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
            list.addFirst(new Node(key, value, freq + 1));
            freqTable.put(freq + 1, list);
            keyTable.put(key, freqTable.get(freq + 1).getHead());
        }
    }
}

class Node{
    int key, val, freq;
    Node prev, next;

    Node(){
        this(-1, -1, 0);
    }

    Node(int key, int val, int freq){
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DoublyLinkedList{
    Node dummyHead, dummyTail;
    int size;

    DoublyLinkedList(){
        dummyHead = new Node();
        dummyTail = new Node();

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        size =0;
    }

    public void  addFirst(Node node){
        Node prevHead = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;

        node.next = prevHead;
        prevHead.prev = node;

        size ++;
    }

    public void remove(Node node){
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        size --;
    }

    public Node getHead(){
        return dummyHead.next;
    }

    public Node getTail(){
        return dummyTail.prev;
    }

}
