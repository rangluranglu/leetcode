package Year2023.Daily.M3.D15;

import java.util.ArrayList;
import java.util.List;

public class q1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        // 网络秩： 与这两座城市直接相连的道路总数，两座城市之间的道路只计算一次
        // i, j 之间没有道路连接， degree[i] + degree[j]
        // i, j 之间有道路连接， degree[i] + degree[j] - 1

        // 枚举
        boolean[][] connect = new boolean[n][n];
        int[] degree = new int[n];

        for(int[] v : roads){
            connect[v[0]][v[1]] = true;
            connect[v[1]][v[0]] = true;

            degree[v[0]] ++;
            degree[v[1]] ++;
        }


        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j] - (connect[i][j] ? 1 : 0);
                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }


    public int maximalNetworkRank2(int n, int[][] roads) {
        // first 表示节点中度数的最大值， second 表示次大值

        boolean[][] connect = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] road : roads) {
            int x = road[0], y = road[1];
            connect[x][y] = true;
            connect[y][x] = true;
            degree[x]++;
            degree[y]++;
        }

        int first = -1, second = -2;
        List<Integer> firstArr = new ArrayList<>();
        List<Integer> secondArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(degree[i] > first){
                second = first;
                secondArr = new ArrayList<>(firstArr);

                first = degree[i];
                firstArr.clear();
                firstArr.add(i);
            }else if(degree[i] == first){
                firstArr.add(i);
            }else if(degree[i] > second){
                secondArr.clear();
                second = degree[i];
                secondArr.add(i);
            }else if(degree[i] == second){
                secondArr.add(i);
            }
        }

        if(firstArr.size() == 1){
            int u = firstArr.get(0);

            for(int v : secondArr){
                if(!connect[u][v]){
                    return first + second;
                }
            }
            return  first + second - 1;
        }else {
            int m = roads.length;
            if(firstArr.size() * (firstArr.size() - 1) / 2 > m){
                return first * 2;
            }

            for(int u : firstArr){
                for(int v : firstArr){
                    if(u != v && !connect[u][v]){
                        return first * 2;
                    }
                }
            }

            return first * 2 - 1;
        }

    }
}
