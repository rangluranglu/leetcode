package Year2022.Week.DW92;

public class q2483 {
    public int bestClosingTime(String customers) {
        // 代价最小， 关门最早
        // i时关门代价计算 ； 0 - (i-1) 的 N 数量 + i - n-1 的 Y 数量
        int n = customers.length();

        int[] right = new int[n];

        int count = 0;
        for(int i = n - 1; i >= 0; i--){
            if(customers.charAt(i) == 'Y'){
                count ++;
            }

            right[i] = count;
        }

        count = 0;
        int ans = 0, ansCost = Integer.MAX_VALUE, cost = 0;
        for (int i = 0; i < n; i++) {
            cost = count + right[i];
            System.out.println(cost);
            if(cost < ansCost){
                ans = i;
                 ansCost = cost;
            }

            if(customers.charAt(i) == 'N'){
                count ++;
            }
        }

        ans = cost < ansCost ? n : ans;

        return ans;
    }


    public int bestClosingTime2(String customers) {
        // 优化：统计出Y的数目
        // 是 N，则代价加一，否则代价减一。

        int ans = 0;
        // 假设总的代价是0；
        int cost = 0;
        int n = customers.length();
        for (int i = 0; i < n; i++) {
            if(customers.charAt(i) == 'N'){
                cost ++;
            }else {
                cost --;
                if(cost < 0){
                    ans = i +1;
                    cost = 0;
                }
            }
        }

        return ans;

    }
}
