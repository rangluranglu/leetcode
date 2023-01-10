package Year2023.Daily.M1.D10;

import java.util.HashSet;
import java.util.Set;

public class q753 {
    Set<Integer> seen = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    int highest;
    int k;

    public String crackSafe(int n, int k) {
        // Hierholzer算法：可以在一个欧拉图中找出欧拉回路
        // 将将所有的 n−1位数作为节点，共有 k^{n-1}个节点，每个节点有k条入边和出边。
        // 如果当前节点的数
        highest = (int) Math.pow(10, n - 1);
        this.k = k;
        dfs(0);
        for(int i = 1; i < n; i++){
            sb.append('0');
        }

        return sb.toString();
    }

    public void dfs(int node){
        for(int x = 0; x < k; x++){
            int nei = node * 10 + x;
            if(!seen.contains(nei)){
                seen.add(nei);
                dfs(nei % highest);
                sb.append(x);
            }
        }
    }
}
