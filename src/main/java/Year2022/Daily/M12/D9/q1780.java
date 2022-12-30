package Year2022.Daily.M12.D9;

public class q1780 {
    public boolean checkPowersOfThree(int n) {
        // 3进制？ 任何数都可以转成3进制， 转成3进制没哟2

        // 进制转换： 十进制 --> 三进制

        while (n != 0){
            if(n % 3 == 2){
                return false;
            }

            n /= 3;
        }

        return true;
    }
}
