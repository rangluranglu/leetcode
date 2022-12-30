package Year2022.Week.DW85;

public class q2379 {
    public int minimumRecolors(String blocks, int k) {
        int black = 0, white = 0;
        int ans = Integer.MAX_VALUE;
        int n = blocks.length();
        // 滑动数组
        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W'){
                white ++;
            }
            else {
                black ++;
            }
        }

        if(black == k){
            return 0;
        }
        if(k == n){
            return white;
        }

        ans = white;

        for(int i = k; i < n; i++){
            if(blocks.charAt(i - k) == 'W'){
                white --;
            }else{
                black --;
            }


            if(blocks.charAt(i) == 'W'){
                white ++;
            }else {
                black ++;
            }

            ans = Math.min(ans, white);

        }

        return ans;
    }
}
