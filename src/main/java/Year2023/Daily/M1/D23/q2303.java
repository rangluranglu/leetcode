package Year2023.Daily.M1.D23;

public class q2303 {
    public double calculateTax(int[][] brackets, int income) {

        double ans = 0;
        int last = 0;
        for(int[] bracket : brackets){
            // 计算
            if(income <= 0){
                break;
            }

            int money = Math.min(bracket[0] - last, income);
            ans += (double) money * bracket[1] / 100;
            last = bracket[0];
            income -= money;
        }

        return ans;
    }
}
