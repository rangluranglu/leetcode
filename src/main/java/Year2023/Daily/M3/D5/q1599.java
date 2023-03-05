package Year2023.Daily.M3.D5;

public class q1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        // 每次的利润  boardingCost * curCustomers - runningCost

        int ans = -1;
        int mx = 0, t = 0;
        int wait = 0, i = 0;

        while (wait > 0 || i < customers.length){
            wait += i < customers.length ? customers[i] : 0;

            int up = Math.min(4, wait);
            wait -= up;

            i ++;

            t += up * boardingCost - runningCost;
            if(t > mx){
                mx = t;
                ans = i;
            }
        }

        return ans;
    }
}
