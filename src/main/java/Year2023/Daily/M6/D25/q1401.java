package Year2023.Daily.M6.D25;

public class q1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 交集
        // 判断圆形圆心 是否在矩形圆角内。

        // 求圆心到矩形区域的最短距离

        double dist = 0;

        if(xCenter < x1 || xCenter > x2){
            dist += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(x2 - xCenter, 2));
        }

        if(yCenter < y1 || yCenter > y2){
            dist += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(y2 - yCenter, 2));
        }


        return  dist <= radius * radius;
    }
}
