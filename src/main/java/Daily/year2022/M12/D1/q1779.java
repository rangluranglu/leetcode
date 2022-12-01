package Daily.year2022.M12.D1;

public class q1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < points.length; i++){
            int[] point = points[i];
            if(x == point[0] || y == point[1]){
                int dist = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if(dist < ans){
                    ans = dist;
                    index = i;
                }
            }
        }

        return index;
    }
}
