package Year2022.Week.DW85;

public class q2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        // 差分数组
        int n = s.length();
        int[] diff = new int[n];

        for(int[] shift : shifts){
            int val = shift[2] == 1 ? 1 : -1;
            diff[shift[0]] += val;
            if(shift[1] + 1 < n){
                diff[shift[1] + 1] -= val;
            }
        }

        // 恢复
        int[] res = new int[n];
        res[0] = diff[0];
        for(int i = 0; i < n; i++){
            res[i] = res[i - 1] + diff[i];
        }

        char[] cur = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int c = cur[i] - 'a';
            c = ((c + res[i]) % 26 + 26) % 26;
            cur[i] = (char) (c + 'a');
        }

        return new String(cur);

    }
}
