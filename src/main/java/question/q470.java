package question;

public class q470 {
    public int rand10() {
        // 使用rand7 实现 rand10
        // 拒绝采样
        int row, col, idx;
        do{
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        }while(idx > 40);

        return idx % 10 + 1;

    }

    public int rand7(){
        return 0;
    }
}
