package question;

public class q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 减小被检查的加油站数目，降低时间复杂度
        // 从 x,y之间的任何一个加油站出发，都无法到达加油站 y 的下一个加油站。

        int n = gas.length;
        int i = 0;
        while(i < n){
            // 从0开始
            int sumOfGas = 0;
            int sumOfCost = 0;
            int cnt = 0;

            while(cnt < n){
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];

                if(sumOfCost > sumOfGas){
                    break;
                }
                cnt ++;
            }

            if(cnt == n){
                return i;
            }else {
                i = i + cnt + 1;
            }
        }

        return -1;
    }
}
