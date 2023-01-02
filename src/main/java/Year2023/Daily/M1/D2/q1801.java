package Year2023.Daily.M1.D2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q1801 {
    int mod = (int) 1e9 + 7;
    public int getNumberOfBacklogOrders(int[][] orders) {
        // 采购订单 --> 查看积压订单中最低销售订单 ， 小于等于 buy 价格， 匹配执行

        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] order : orders){
            int price = order[0], amount = order[1], orderType = order[2];

            if(orderType == 0){
                // 采购。
                while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= price){

                    int[] sellOrder = sellOrders.poll();
                    int sellAmount = Math.min(amount, sellOrder[1]);

                    amount -= sellAmount;
                    sellOrder[1] -= sellAmount;

                    if(sellOrder[1] > 0){
                        sellOrders.offer(sellOrder);
                    }

                }

                if(amount > 0){
                    buyOrders.offer(new int[]{price, amount});
                }

            }else{
                while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= price){
                    int[] buyOrder = buyOrders.poll();
                    int buyAmount = Math.min(amount, buyOrder[1]);

                    amount -= buyAmount;
                    buyOrder[1] -= buyAmount;

                    if(buyOrder[1] > 0){
                        buyOrders.offer(buyOrder);
                    }

                }

                if(amount > 0){
                    sellOrders.offer(new int[]{price, amount});
                }
            }
        }

        int total = 0;
        for(PriorityQueue<int[]> pq : Arrays.asList(buyOrders, sellOrders)){
            while (!pq.isEmpty()){
                int[] order = pq.poll();
                total = (total + order[1]) % mod;
            }
        }

        return total;
    }
}
