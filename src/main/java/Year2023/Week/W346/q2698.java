package Year2023.Week.W346;

public class q2698 {

    private static final int[] PRE_SUM = new int[1001];

    static {

        for(int i = 1; i <= 1000; i++){
            char[] s = Integer.toString(i * i).toCharArray();
            PRE_SUM[i] = PRE_SUM[i - 1] + (dfs(s, i, 0, 0) ? i * i : 0);
        }
    }

    private static boolean dfs(char[] s, int i, int p, int sum){
        if(p == s.length){
            return sum == i;
        }

        int x = 0;
        for (int j = p; j < s.length; j++){
            x = x * 10 + s[j] - '0';
            if(dfs(s, i, j + 1, sum + x)){
                return true;
            }

        }

        return false;

    }
    public int punishmentNumber(int n) {
        // 惩罚数 n <= 1000 i * i
        // 预处理


        return PRE_SUM[n];
    }
}
