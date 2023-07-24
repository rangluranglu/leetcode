package question;

import java.util.HashMap;
import java.util.Map;

class q146 {


}

class LRUCache {
    // 最近最少使用

    // 频次统计
    Map<Integer, LRUNode> counts;
    int capacity;
    int size;

    // 定义头尾 尾节点
    LRUNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        counts = new HashMap<>();
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!counts.containsKey(key)){
            return -1;
        }

        LRUNode node = counts.get(key);
        // 将node插入头节点
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        // 放入
        LRUNode node = counts.get(key);
        if(node == null){
            // 不存在，创建新节点
            LRUNode newNode = new LRUNode(key, value);
            counts.put(key, newNode);
            addToHead(newNode);
            size ++;
            if(size > capacity){
                // 超出容量
                LRUNode lastTail = removeTail();
                counts.remove(lastTail.key);
                size --;
            }
        }else {
            // key存在
            node.value = value;
            moveToHead(node);
        }
    }

    private LRUNode removeTail(){
        LRUNode prev = tail.prev;
        removeNode(prev);

        return prev;
    }
    private void moveToHead(LRUNode node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(LRUNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(LRUNode node){
        node.prev = head;
        node.next =  head.next;
        head.next.prev = node;
        head.next = node;

    }
}

class  LRUNode{
    int key;
    int value;

    LRUNode prev;

    LRUNode next;

    public LRUNode(){

    }

    public LRUNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}