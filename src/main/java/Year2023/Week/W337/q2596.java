package Year2023.Week.W337;

public class q2596 {
    int[][] directions = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    public boolean checkValidGrid(int[][] grid) {
        // 由 [0, n * n -1] 的不同整数组成

        // 是否合法， 可以垂直移动两个格子且水平移动一个格子, 或水平移动两个格子且垂直移动一个格子

        int n = grid.length;
        int start = 0;

        if(grid[0][0] != start){
            return false;
        }
        int startx = 0, starty = 0;
        while (start == grid[startx][starty]){
            for(int[] dir : directions){
                int newx = startx + dir[0];
                int newy = starty + dir[1];

                if(newx >= 0 && newx < n && newy >= 0 && newy < n && grid[newx][newy] == start + 1){
                    startx = newx;
                    starty = newy;
                }
            }
            start ++;
        }
        System.out.println(start);
        return start == n * n;

    }
}
