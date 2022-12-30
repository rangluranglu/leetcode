package Year2022.Daily.M8.D23;

public class q782 {
    public int movesToChessboard(int[][] board) {
        // 可以推出矩阵一定只能包含有两种不同的行，要么与第一行的元素相同，要么每一行的元素刚好与第一行的元素“相反”。

        int n = board.length;
        int rowMask = 0, colMask = 0;
        // 前置判断

        // 第一行和第一列掩码
        for (int i = 0; i < n; i++) {
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }

        int reverseRowMask = ((1 << n) - 1) ^ rowMask;
        int reverseColMask = ((1 << n) - 1) ^ colMask;

        int rowCnt = 0, colCnt = 0;

        for (int i = 0; i < n; i++) {
            int currRowMask = 0;
            int currColMask = 0;

            for (int j = 0; j < n; j++) {
                currRowMask |= (board[i][j] << j);
                currColMask |= (board[j][i] << j);
            }

            // 检测每一行是否合法
            if(currRowMask != rowMask && currRowMask != reverseRowMask){
                return -1;
            }else if(currRowMask == rowMask){
                rowCnt ++;
            }

            // 检测每一列是否合法
            if(currColMask != colMask && currColMask != reverseColMask){
                return -1;
            }else if(currColMask == colMask){
                colCnt ++;
            }
        }

        int rowMoves = getMoves(rowMask, rowCnt, n);
        int colMoves = getMoves(colMask, colCnt, n);


        return (rowMoves == -1 || colMoves == -1) ? -1 : (rowMoves + colMoves);
    }

    // 计算最短移动次数
    private int getMoves(int mask, int count, int n) {
        // mask 中的1个数
        int ones = Integer.bitCount(mask);

        if((n & 1) == 1){
            // 奇数

            /* 如果 n 为奇数，则每一行中 1 与 0 的数目相差为 1，且满足相邻行交替 */
            if (Math.abs(n - 2 * ones) != 1 || Math.abs(n - 2 * count) != 1 ) {
                return -1;
            }
            if (ones == (n >> 1)) {
                /* 以 0 为开头的最小交换次数 */
                return n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            } else {
                return (n + 1) / 2 - Integer.bitCount(mask & 0x55555555);
            }
        } else {
            /* 如果 n 为偶数，则每一行中 1 与 0 的数目相等，且满足相邻行交替 */
            if (ones != (n >> 1) || count != (n >> 1)) {
                return -1;
            }
            /* 找到行的最小交换次数 */
            int count0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            int count1 = n / 2 - Integer.bitCount(mask & 0x55555555);
            return Math.min(count0, count1);
        }

    }
}
