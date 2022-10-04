package WeekCompetition.year2022;

import java.util.*;

public class q2 {
    public static void main(String[] args) {
        String a = "abcc";
        System.out.println(equalFrequency(a));

    }
    public static boolean equalFrequency(String word) {
        int n = word.length();

        int[] count = new int[26];

        for(char ch : word.toCharArray()){
            count[ch - 'a'] ++;
        }


        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.size());
        for (int i = 0; i < 26; i++) {
            map.put(count[i], map.getOrDefault(count[i], 0) + 1);
        }
        if(map.size() > 2){
            return false;
        }
        if(map.size() == 2){
            int[] a = new int[2];
            int i = 0;
            for(Integer v : map.keySet()){
                a[i] = v;
                i++;
            }
            if(map.get(a[0]) > 1 && map.get(a[1]) > 1){
                return false;
            }
            return Math.abs(a[0] - a[1]) == 1;
        }

        for(Integer v : map.values()){
            return v > 2;
        }

        return false;

    }

    public int commonFactors(int a, int b) {
        if(b < a){
            return commonFactors(b, a);
        }

        int ans = 0;
        for (int i = 1; i <= a ; i++) {
            if(a % i == 0 && b % 1 ==0 ){
                ans += 1;
            }
        }

        return ans;
    }


    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // 预处理
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][2] = grid[i][0] + grid[i][1] + grid[i][2];
            for (int j = 3; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + grid[i][j] - grid[i][j - 3];
            }
        }

        System.out.println(Arrays.deepToString(sum));
        int ans = 0;
        for (int i = 0; i < m - 2; i++) {
            for(int j = 2; j < n; j++){
                int tmp = sum[i][j] + sum[i + 2] [j] + grid[i + 1][j - 1];
                if(tmp > ans){
                    ans = tmp;
                }
            }
        }

        return ans;
    }


    public int minimizeXor(int num1, int num2) {
        int count_num2 = Integer.bitCount(num2);
        int count_num1 = Integer.bitCount(num1);

        System.out.println(count_num1 + "---" + count_num2);
        if(count_num1 == count_num2){
            return num1;
        }
        if(count_num1 < count_num2){
            int a = count_num2 - count_num1;
            int map = 1;
            int ans = num1;
            while (a != 0){
                if((num1 & map) != 0){
                    map <<= 1;
                }else {
                    num1 |= map;
                    map <<= 1;
                    a --;
                }
            }

            return ans;
        }
        if(count_num2 < count_num1){
            int a = count_num2 - count_num1;
            int ans = num1;
            while (a != 0){
                // 取出左边的a个1
                ans &= (ans - 1);
                a --;
            }
            return ans;
        }
        return 0;

    }
    int ans = 0;
    public int deleteString(String s) {
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(0)){
                if(i == 1){
                    ans ++;
                    return deleteString(s.substring(i));

                }else {
                    if(i+i > s.length()){
                        return ans;
                    }
                    if(s.substring(0, i).equals(s.substring(i, i + i))){

                        deleteString(s.substring(i));
                        ans++;

                    }
                }
            }

        }

        return ans;
    }
}
