package Template;

public class BIT {

    // tree[x] 保存以x为根的子树中叶节点值的和
    // tree[x] 节点覆盖的长度就是 lowBit(x)
    // tree[x] 节点的父节点为 tree[x + lowBit(x)]
    private final int[] tree;

    public BIT(int n){
        tree = new int[n];
    }


    // 下标i加x
    public void incr(int i, int x){
        while (i < tree.length){
            tree[i] += x;

            i += i & -i;
        }
    }

    // 返回区间[1, i]的和
    public int sum(int x){
        int res = 0;

        while (x > 0){
            res += tree[x];

            x &= x - 1;
        }

        return res;
    }


    public int query(int l, int r){
        return sum(r) - sum(l - 1);
    }
}
