package WeekCompetition.year2022.DW86;

import java.util.*;

public class q6173 {
    public static void main(String[] args) {
        int[][] a = {{0,0,0}, {1,0,1}, {0,1,1}, {0,0,1}};
        System.out.println(maximumRows(a, 2));
    }
    public static int maximumRows(int[][] mat, int cols) {
        // 存每行1对应的列数
        int m = mat.length, n = mat[0].length;
        dfs(n, 0, new ArrayList<>(), cols);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.put(i, new ArrayList<>());
            for(int j = 0; j < n; j++){
                List<Integer> set = map.get(i);
                if(mat[i][j] == 1){
                    set.add(j);
                }
            }
        }

        System.out.println(map);
        // 先找列小于等于 cols 的行
        Map<List<Integer>, Integer> count = new HashMap<>();
        for(List<Integer> list : ans){
            count.put(list, 0);
        }

        for(int i = 0; i < m; i++){
            // 行数所保存的1
            List<Integer> list = map.get(i);
            if(list.size() > cols){
                continue;
            }

            if(list.size() <= cols){

                for(List<Integer> l : count.keySet()){
                    boolean flag = false;
                    for(int j = 0; j < list.size(); j++){
                        if(!l.contains(list.get(j))){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        continue;
                    }
                    count.put(l, count.get(l) + 1);
                }
            }
        }

        System.out.println(count);
        int res = 0;
        for(int a : count.values()){
            res = Math.max(a, res);
        }

        return res;

    }

    static List<List<Integer>> ans = new ArrayList<>();
    public static void dfs(int n, int start, List<Integer> depth, int target){
        if(start > n){
            return;
        }
        if(depth.size() == target){
            ans.add(new ArrayList<Integer>(depth));
            return;
        }
        depth.add(start);
        dfs(n, start + 1, depth, target);
        depth.remove(depth.size() - 1);
        dfs(n, start + 1, depth, target);
    }
}
