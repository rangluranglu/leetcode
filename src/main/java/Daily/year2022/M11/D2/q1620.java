package Daily.year2022.M11.D2;

public class q1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        // 数据量很小可以枚举
        // 找到最远的x y 坐标
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        for(int[] tower : towers){
            xMax = Math.max(xMax, tower[0]);
            yMax = Math.max(yMax, tower[1]);

        }

        int x = 0, y = 0;
        int maxSignal = 0;

        for (int i = 0; i <= xMax; i++) {
            for (int j = 0; j <= yMax; j++) {
                int[] target = {i, j};
                // 计算强度
                int signal = 0;
                for(int[] tower : towers){
                    // 遍历信号塔
                    int distance = getDistance(target, tower);
                    if(distance <= radius * radius){
                        signal += (int) Math.floor(tower[2] / (1 + (double) Math.sqrt(distance)));
                    }

                    if(signal > maxSignal){
                        x = i;
                        y = j;
                        maxSignal = signal;
                    }
                }

            }
        }

        return new int[]{x, y};
    }

    private int getDistance(int[] coordinate, int[] tower) {
        return (tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]);
    }


}
