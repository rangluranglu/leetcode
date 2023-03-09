package Year2023.Daily.M3.D9;

public class q2379 {
    public int minimumRecolors(String blocks, int k) {
        // 连续k个
        // 滑动窗口

        int n = blocks.length();
        int left = 0;
        int cnt = 0, res = Integer.MAX_VALUE;
        for(int right = 0; right < n; right++){
            cnt += blocks.charAt(right) == 'W' ? 1 : 0;

            if(right - left + 1 == k + 1){
                cnt -= blocks.charAt(left) == 'W' ? 1 : 0;
                left ++;
            }

            if(right - left + 1 == k){
                res = Math.min(res, cnt);
            }
        }

        return res;


    }
}
