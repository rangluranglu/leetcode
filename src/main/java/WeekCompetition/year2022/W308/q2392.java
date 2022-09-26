package WeekCompetition.year2022.W308;

import java.util.*;

public class q2392 {
    public static void main(String[] args) {
        int[][] a = {{1,2}, {3,2}};
        int[][] b = {{2,1},{3,1}};

        System.out.println(Arrays.deepToString(buildMatrix(3, a, b)));
    }
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = findOrder(k, rowConditions);
        if(rowOrder.length == k - 1){
            return new int[0][0];
        }
        System.out.println(Arrays.toString(rowOrder));
        int[] colOrder = findOrder(k, colConditions);
        if(colOrder.length == k - 1){
            return new int[0][0];
        }
        System.out.println(Arrays.toString(colOrder));

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            map.put(colOrder[i], i);
        }

        int[][] ans = new int[k][k];

        for(int i = 0; i < k; i++){
            int num = rowOrder[i];
            int col = map.get(num);

            ans[i][col] = num;
        }

        return ans;

    }

    public static int[] findOrder(int k, int[][] rowConditions){
        // 拓扑排序确定顺序
        int n = rowConditions.length;
        int[] indeg = new int[k + 1];
        int[] ans = new int[k];
        // 边
        List<List<Integer>> edges =  new ArrayList<>();

        for(int i = 0; i <= k; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] con : rowConditions){
            edges.get(con[0]).add(con[1]);
            indeg[con[1]] ++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= k; i++){
            if (indeg[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()){
            int u = queue.poll();
            ans[index] = u;
            index ++;

            for(int v : edges.get(u)){
                indeg[v] --;
                if(indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }

        if(index != k){
            return new int[k - 1];
        }

        return ans;
    }
}
