package Year2022.Daily.M9.D3;

import java.util.Arrays;

public class q646 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{-6, 9},{1,6},{8,10},{-1, 4}, {-6, -2}, {-9, 8}, {-5,3}, {0,3}};
        System.out.println(findLongestChain(arr));
    }
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1]-b[1]);
        System.out.println(Arrays.deepToString(pairs));

        int[] last = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            // 贪心
            int[] pair = pairs[i];
            if(pair[0] > last[0] && pair[0] > last[1]){
                ans+=1;
                last = pair;
            }
        }

        return ans;
    }
}
