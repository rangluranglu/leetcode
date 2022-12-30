package Year2022.Week.DW87;

public class q2412 {
    public long minimumMoney(int[][] transactions) {
        // 贪心
        // 考虑最坏的情况， 先亏钱再赚钱
        // transactions = [cost, cashback]

        // 对于cost_i <= cashback_i 的交易，这笔交易可以发生在亏钱后，此时初始 money = totalLose + cost_i;
        // 对于cost_i > cashback_i 的交易，这笔交易可以发生在最后一笔亏钱时，由于已经计入totalLose 中，需要从 totalLose 中减去
        // cost_i - cashback_i，再加上cost_i 得到 money = totalLost + cashback_i;
        long totalLose = 0L;
        long mx = 0;

        for(int[] t : transactions){
            totalLose += Math.max(t[0] - t[1], 0);
            mx = Math.max(mx, Math.min(t[0], t[1]));
        }

        return totalLose + mx;
    }
}
