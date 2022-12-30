package Year2022.Week.W306;

public class q2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length;

        int[] count = new int[n];

        int ans = -1, ret = 0;

        for(int i = 0; i < n; i++){
            count[edges[i]] += i;

            if(count[edges[i]] > ans){
                ans = count[edges[i]];
                ret = edges[i];
            }else if(count[edges[i]] == ans && edges[i] < ret){
                ret = edges[i];
            }
        }

        return ret;
    }
}
