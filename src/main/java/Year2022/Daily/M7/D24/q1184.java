package Year2022.Daily.M7.D24;

public class q1184 {
    public static void main(String[] args) {
        int[] sum = {7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops(sum,7,2));
    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination){
            return distanceBetweenBusStops(distance, destination,start);
        }
        int n = distance.length;

        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + distance[i - 1];
        }

        return Math.min(preSum[destination] -preSum[start], preSum[n] - preSum[destination] + preSum[start]);
    }
}
