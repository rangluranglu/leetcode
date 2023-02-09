package Year2023.Daily.M2.D9;

import java.util.HashMap;
import java.util.Map;

public class q1797 {
}

class AuthenticationManager {
    // 所有函数的调用次数总共不超过 2000 次。


    // 有双向链表保存验证码和过期时间顺序
    int timeToLive;
    Node head;
    Node tail;
    Map<String, Node> map;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }

    // 生成
    public void generate(String tokenId, int currentTime) {
        Node node = new Node(currentTime + timeToLive, tokenId);

        map.put(tokenId, node);
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    // 更新
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId).expire > currentTime){
            // 更新
            Node node = map.get(tokenId);

            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.expire = currentTime + timeToLive;
            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            tail.prev = node;
            node.next = tail;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (head.next.expire > 0 && head.next.expire <= currentTime){
            Node node = head.next;
            map.remove(node.key);
            head.next = node.next;
            node.next.prev = head;
        }

        return map.size();
    }
}

class Node{
    int expire;
    String key;
    Node prev;
    Node next;

    public Node(int expire){
        this(expire, null, null, null);
    }

    public Node(int expire, String key){
        this(expire, key, null, null);
    }

    public Node(int expire, String key, Node prev, Node next){
        this.expire = expire;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}