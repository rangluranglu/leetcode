package Year2023.Week.DW100;

public class q2591 {
    public int distMoney(int money, int children) {

        // 先确保每人有糖果

        money -= children;

        if(money < 0){
            return -1;
        }

        if(money == 0){
            return 0;
        }


        // 然后分7个
        int mod = money % 7;
        int peo = money / 7;


        if(peo == children){
            // 全部分完
            if(mod == 0){
                return children;
            }
            return children -1;
        }else if(peo > children){
            return children - 1;
        }else {
            // peo < children

            if(mod != 3){
                return peo;
            }else {
                if(peo == children - 1){
                    return peo - 1;
                }else {
                    return peo;
                }
            }
        }






    }
}
