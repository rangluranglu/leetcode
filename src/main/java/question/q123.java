package question;

public class q123 {
    public int maxProfit(int[] prices) {
        // 最多两笔交易
        // 动态规划
        int n = prices.length;
        // 只买了一次， 一次买和一次卖， 完成第一次交易后第二次买， 完成两笔交易
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;

        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);

            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}
