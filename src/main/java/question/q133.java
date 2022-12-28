package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class q133 {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // clone
        // dfs
        // 拷贝
        if(node == null){
            return node;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node nNode = new Node(node.val);
        map.put(node, nNode);
        for(Node n : node.neighbors){
            // 克隆
            nNode.neighbors.add(cloneGraph(n));
        }
        return nNode;
    }
}
