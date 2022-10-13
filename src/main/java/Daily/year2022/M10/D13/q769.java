package Daily.year2022.M10.D13;

public class q769 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, m = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);

            if(m == i){
                ans ++;
            }
        }

        return ans;
    }
}
