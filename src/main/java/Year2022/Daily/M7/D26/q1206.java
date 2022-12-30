package Year2022.Daily.M7.D26;

import java.util.Arrays;
import java.util.Random;

public class q1206 {
}

class Skiplist {

    static final int MAX_LEVEL = 32;
    static final double P_FACTOR = 0.25;
    private SkiplistNode head;
    private int level;
    private Random random;

    public Skiplist() {
        this.head = new SkiplistNode(-1, MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }

    public boolean search(int target) {
        // 头结点
        SkiplistNode curr = this.head;

        // i层数
        for(int i = level - 1; i >= 0; i--){
            /*找到第i层小于且最接近target的元素*/
            while(curr.forward[i] != null && curr.forward[i].val < target){
                curr = curr.forward[i];
            }
        }

        // curr为最 小于且最接近 target 的元素，检查下一个元素是否为target
        curr = curr.forward[0];
        if(curr != null && curr.val == target){
            return true;
        }

        return false;
    }

    public void add(int num) {
        // 数组存储每一层 小于且最洁净target的节点
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(update, head);
        SkiplistNode curr = this.head;

        for(int i = level - 1; i >= 0; i--){
            while(curr.forward[i] != null && curr.forward[i].val < num){
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int lv = randomLevel();
        // 更新level
        level = Math.max(lv, level);

        SkiplistNode newNode = new SkiplistNode(num, lv);

        for(int i = 0; i < lv; i++){
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        SkiplistNode curr = this.head;

        for(int i = level - 1; i >= 0; i--){
            while(curr.forward[i] != null && curr.forward[i].val < num){
                curr = curr.forward[i];
            }

            update[i] = curr;
        }

        curr = curr.forward[0];
        if(curr == null || curr.val != num){
            return false;
        }

        // 进行擦除
        // 从第一层开始更新
        for(int i = 0; i < level; i++){
            // 更新结束
            if(update[i].forward[i] != curr){
                break;
            }

            update[i].forward[i] = curr.forward[i];
        }

        // 更新当前的level
        while(level > 1 && head.forward[level - 1] == null){
            level --;
        }

        return true;
    }

    // 生成随机level
    private int randomLevel(){
        int lv = 1;
        while(random.nextDouble() < P_FACTOR && lv < MAX_LEVEL){
            lv ++;
        }

        return lv;
    }
}

class SkiplistNode{
    int val;
    SkiplistNode[] forward;

    public SkiplistNode(int val, int maxLevel){
        this.val = val;
        this.forward = new SkiplistNode[maxLevel];
    }
}
