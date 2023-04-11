package Year2023.Daily.M4.D11;

public class q1041 {
    public boolean isRobotBounded(String instructions) {
        // 问题：怎么判断有环 --> 只有 不位于原点并且方向朝北时 可以摆脱循环

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;

        int x = 0, y = 0;
        int n = instructions.length();

        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            switch (c){
                case 'G':
                    x += directions[directIndex][0];
                    y += directions[directIndex][1];
                    break;

                case 'L':
                    directIndex += 3;
                    directIndex %= 4;
                    break;
                default:
                    directIndex ++;
                    directIndex %= 4;
            }
        }

        return directIndex != 0 || (x == 0 && y == 0);  // !((x==0&&y==0) && directIndex != 0)


    }
}
