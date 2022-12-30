package Year2022.Week.W314;

public class q2432 {
    public int hardestWorker(int n, int[][] logs) {
        int max = logs[0][1];
        int id = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            if(logs[i][1] - logs[i - 1][1] > max){
                max = logs[i][1] - logs[i-1][1];
                id = logs[i][0];
            }else if(logs[i][1] - logs[i - 1][1] == max && logs[i][0] < id){
                id = logs[i][0];
            }
        }

        return id;
    }
}
