package Year2022.Daily.M8.D19;

public class q1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(queryTime >= startTime[i] && queryTime <= endTime[i]){
                ans += 1;
            }
        }

        return ans;
    }
}
