package Year2023.Daily.M1.D5;

public class q1803 {
    private Trie root = null;

    private static final int HIGH_BIT = 14;


    public int countPairs(int[] nums, int low, int high) {
        // 字典树
        // f(high) - f(low - 1)
        // 将数组看成是长度15 的长度
        // 枚举元素 ai， 求解有多少元素 aj (j < i) 是 ai ^ aj <= x;
        return f(nums, high) - f(nums, low - 1);
    }

    public int f(int[] nums, int x){
        root = new Trie();
        int res = 0;

        for(int i = 1; i < nums.length; i++){
            // 枚举ai , 将 a(i - 1)放入字典树中
            add(nums[i - 1]);
            res += get(nums[i], x);
        }

        return res;
    }

    public void add(int num){
        Trie cur = root;
        for(int k = HIGH_BIT; k >= 0; k --){
            int bit = (num >> k) & 1;

            if(cur.son[bit] == null){
                cur.son[bit] = new Trie();
            }

            cur = cur.son[bit];
            cur.sum ++;
        }
    }

    public int get(int num, int x){
        Trie cur = root;
        int sum = 0;

        for(int k = HIGH_BIT; k >= 0; k --){
            int r = (num >> k) & 1;

            if(((x >> k) & 1) != 0){
                // k 的 下一层 是 1
                if(cur.son[r] != null){
                    sum += cur.son[r].sum;
                }

                if(cur.son[r ^ 1] == null){
                    return sum;
                }

                cur = cur.son[r ^ 1];
            }else{
                if(cur.son[r] == null){
                    return sum;
                }
                // k 的 第i为是0， 进入下一层
                cur = cur.son[r];
            }
        }

        sum += cur.sum;
        return sum;
    }
}

class Trie{
    Trie[] son = new Trie[2];
    int sum;

    public Trie(){
        sum = 0;
    }
}
