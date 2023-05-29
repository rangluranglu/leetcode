package Year2023.Daily.M5.D27;

import java.util.Arrays;

public class q1093 {
    public double[] sampleStats(int[] count) {
        // 模拟

        int n = count.length;

        int total = Arrays.stream(count).sum();
        // 平均值
        double mean = 0.0;

        // 中位数
        double median = 0.0;

        int minnum = 256;
        int maxnum = 0;
        int mode = 0;

        int left = (total + 1) / 2;
        int right = (total + 2) / 2;

        int cnt = 0;
        int maxfreq = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (long) count[i] * i;

            if(count[i] > maxfreq){
                maxfreq = count[i];
                mode = i;
            }

            if(count[i] > 0){
                if(minnum == 256){
                    minnum = i;
                }

                maxnum = i;
            }

            if(cnt < right && cnt + count[i] >= right){
                median += i;
            }

            if(cnt < left && cnt + count[i] >= left){
                median += i;
            }

            cnt += count[i];
        }

        mean = (double) sum / total;
        median =  median / 2.0;

        return new double[]{minnum, maxnum, mean, median, mode};
    }
}
