package Daily.year2022.M11.D10;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class q864 {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        // 广度优先搜索
        // '.' 代表一个空房间
        // '#' 代表一堵
        // '@' 是起点
        int m = grid.length;
        int n = grid[0].length();
        int sx = 0, sy = 0;
        Map<Character, Integer> keyToIndex = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String str = grid[i];
            for (int j = 0; j < n; j++) {
                if(str.charAt(j) == '@'){
                    // 找到起点
                    sx = i;
                    sy = j;
                }else if(Character.isLowerCase(str.charAt(j))){
                    // 是钥匙，添加
                    if(!keyToIndex.containsKey(str.charAt(j))){
                        int index = keyToIndex.size();
                        keyToIndex.put(str.charAt(j), index);
                    }
                }
            }
        }


        Queue<int[]> queue = new ArrayDeque<>();
        // 状态压缩
        int[][][] dist = new int[m][n][1 << keyToIndex.size()];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        queue.offer(new int[]{sx, sy, 0});
        dist[sx][sy][0] = 0;

        while (!queue.isEmpty()){
            // 广度优先搜素
            int[] arr = queue.poll();
            // mask 是二进制，长度等于钥匙数目。
            int x = arr[0], y = arr[1], mask = arr[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                // 不是墙
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx].charAt(ny) != '#'){
                    if(grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@'){
                        if(dist[nx][ny][mask] == -1){
                            // 第一次路过
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    }else if (Character.isLowerCase(grid[nx].charAt(ny))){
                        // 是钥匙
                        int idx = keyToIndex.get(grid[nx].charAt(ny));
                        if(dist[nx][ny][mask | (1 << idx)] == -1){
                            // 第一次找到钥匙
                            dist[nx][ny][mask | (1 << idx)] = dist[x][y][mask] + 1;
                            if((mask | (1 << idx)) == (1 << keyToIndex.size()) - 1){
                                // 找到钥匙了
                                return dist[nx][ny][mask | (1 << idx)];
                            }
                            queue.offer(new int[]{nx, ny, (mask | (1 << idx))});
                        }
                    } else {
                        int idx = keyToIndex.get(Character.toLowerCase(grid[nx].charAt(ny)));
                        // 是锁, 找到钥匙的idx
                        if ((mask & (1 << idx)) != 0 && dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    }
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 5);
    }
}
