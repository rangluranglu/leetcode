package question;

public class offer12 {
    boolean flag = false;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)){
                    dfs(board, i, j, 0, word);
                    if(flag){
                        return flag;
                    }
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, int i, int j, int index, String word){
        if(word.charAt(index) != board[i][j]){
            return;
        }

        if(index == word.length() - 1){
            flag = true;
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int dx = directions[k][0] + i;
            int dy = directions[k][1] + j;
            if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                if(!visited[dx][dy]){
                    dfs(board, dx, dy, index + 1, word);
                }
            }
        }


        visited[i][j] = false;

    }
}
