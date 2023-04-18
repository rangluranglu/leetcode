package Template;

import java.util.Comparator;
import java.util.Objects;

public class redBlackTree<K extends Comparable<K>, V> {
    class Node{
        public static final boolean RED = true;
        public static final boolean BLACK = false;

        public K key;
        public V value;

        public Node left;
        public Node right;

        public boolean color;

        public int size = 1;

        public Node(K key, V value, boolean color){
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public Node getLeft(){
            return this.left;
        }

        public Node getRight(){
            return this.right;
        }

        public boolean getColor(){
            return this.color;
        }
    }


    // 判断节点颜色
    protected boolean isRed(Node node){
        if(Objects.isNull(node)){
            return Node.BLACK;
        }

        return node.color;
    }


    // 在实现红黑树的插入或者删除操作可能会出现红色节点在右边或者两个连续的红色节点，在出现这些情况的时候我们需要通过旋转操作来完成修复。
    // 左旋

    protected Node rotateLeft(Node h){
        // 新的头节点
        Node x = h.right;

        h.right = x.left;

        x.left = h;

        x.color = h.color;
        h.color = Node.RED;

        size(h);
        size(x);


        return x;
    }


    protected Node rotateRight(Node h){
        Node x = h.left;

        h.left = x.right;

        x.right = h;

        x.color = h.color;
        h.color = Node.RED;

        size(h);
        size(x);

        return x;
    }

    // 变色，达到节点分裂
    // 要求根节点是黑色的
    protected void upSplit(Node node){
        if(Objects.isNull(node)){
            return;
        }

        node.left.color = Node.BLACK;
        node.right.color = Node.BLACK;
        node.color = Node.RED;
    }


    // 插入
    // 若右子节点是红色，左子节点是黑树，那么就进行左旋
    // 若左子节点是红色且他的左子节点也是红色，那么就进行右旋
    // 若左右子节点都是红色，那么就进行颜色转换
    Node root;

    public void put(K key, V value){
        if(Objects.isNull(key)){
            return;
        }

        root = put(root, key, value);
        root.color = Node.BLACK;
    }

    // 递归
    private Node put(Node node, K key, V value){
        if(Objects.isNull(node)){
            return new Node(key, value, Node.RED);
        }

        int compare = key.compareTo(node.key);

        if(compare > 0){
            // 在右边
            node.right = put(node.right, key, value);
        }else if(compare < 0){
            node.left = put(node.left, key, value);
        }else {
            node.value = value;
        }

        // 递归结束 后的判断
        // 每个都有检测
        if(isRed(node.right) && !isRed(node.left)){
            node = rotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }

        if(isRed(node.left) && isRed(node.right)){
            upSplit(node);
        }

        size(node);
        return node;
    }


    // 删除操作
    // 所以红黑树的删除操作的关键就是需要保证待删除节点是一个双键的节点。

    protected void flipColors(Node h){
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    // 删除最小值
    // 保证待删除的节点是一个双键的节点，所以在在递归到每个节点是都需要保住当前节点是双键节点，
    // 那么在最后找到的最小值就一定会在一个双键节点中（因为递归时已经保住的父节点是双键节点）。

    // 1. 当前节的左子节点是双键， 直接删除
    // 2. 当前节点的左子节点是单键，兄弟节点是双键， 通过旋转移动左子节点形成双键，删除
    // 3. 当前节点的左右都是单键，通过变色
    public void deleteMin(){
        if(isEmpty()){
            return;
        }

        if(!isRed(root.left) && !isRed(root.right)){
            // 左黑， 右黑
            root.color = Node.RED;
        }

        root = deleteMin(root);

        if(!isEmpty()){
            root.color = Node.BLACK;
        }
    }

    private Node deleteMin(Node h){
        if(h.left == null){

            return null;
        }

        if(!isRed(h.left) && !isRed(h.left.left)){
            // 左， 左的左是黑色
            // 2-3 树当前节点的左孩子容量为 1
            h = moveToRedLeft(h);
        }

        h.left = deleteMin(h.left);
        return balance(h);
    }

    // 使当前节点容量不是1
    private Node moveToRedLeft(Node h){
        flipColors(h);


    }
}
