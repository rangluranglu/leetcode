package Year2023.Week.W345;

public class q2683 {
    public boolean doesValidArrayExist(int[] derived) {
        // 同样长度的original 相邻异或派生来的
        // derived[i] = original[i] ^ original[i + 1]

        // 计算是否存在original

        boolean flag = true;

        for(int d : derived){
            if(d == 1){
                flag = !flag;
            }
        }

        return flag;
    }
}
