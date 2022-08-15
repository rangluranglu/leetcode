package question;

import java.util.*;

public class q51 {
    // N皇后
    public List<List<String>> solveNQueens(int n) {
        // 要求皇后彼此之间不能相互攻击，等价于要求任何两个皇后都不能在同一行、同一列以及同一条斜线上
        // 回溯
        // 使用数组记录每行防止的列下标，依次在每行放置一个皇后。

        List<List<String>> ans = new ArrayList<>();
        // 记录每行的皇后的列
        int[] queens = new int[n];
        Arrays.fill(queens, 1);

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonal = new HashSet<>();
        Set<Integer> backdiagonal = new HashSet<>();

        backtrace(ans, queens, n, 0, columns, diagonal, backdiagonal);
        return ans;
    }

    private void backtrace(List<List<String>> ans, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonal, Set<Integer> backdiagonal) {
        if(row == n){
            List<String> board = generateBoard(queens, n);
            ans.add(board);
        }else{
            // 枚举每列
            for (int i = 0; i < n; i++) {
                if(columns.contains(i)){
                    continue;
                }
                // 主对角线 行-列 一定
                int diagonal1 = row - i;
                if(diagonal.contains(diagonal1)){
                    continue;
                }

                // 副对角线 行 + 列 一定
                int diagonal2 = row + i;
                if(backdiagonal.contains(diagonal2)){
                    continue;
                }

                queens[row] = i;

                // 向set添加
                columns.add(i);
                diagonal.add(diagonal1);
                backdiagonal.add(diagonal2);

                // 回溯
                backtrace(ans, queens, n, row + 1, columns, diagonal, backdiagonal);

                //
                queens[row] = -1;
                columns.remove(i);
                diagonal.remove(diagonal1);
                backdiagonal.remove(diagonal2);
            }
        }

    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }

        return board;

    }


}
