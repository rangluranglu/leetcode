package Year2022.Daily.M8.D10;

import java.util.Arrays;

public class q640 {
    public static void main(String[] args) {
        String a = "0x=0";
        System.out.println(solveEquation(a));
    }
    public static String solveEquation(String equation) {
        String[] split = equation.split("=");

        int[] count = count(split[0]);
        int[] count1 = count(split[1]);
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(count1));
        if(count[1] == count1[1] && count[0] == count1[0]){
            return "Infinite solutions";
        }
        if(count[0] == count1[0]){
            return "No solution";
        }

        return "x=" + String.valueOf((count1[1] - count[1]) / (count[0] - count1[0]));
    }



    public static int[] count(String str){
        int[] ans = new int[2];
        int i = 0, flag = 1;
        while(i < str.length()){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                flag = str.charAt(i) == '+' ? 1 : -1;
                i ++;
            }
            int val = 0;
            boolean cnt = false;
            while(i < str.length() && Character.isDigit(str.charAt(i))){
                val = val * 10 + str.charAt(i) - '0';
                i ++;
                cnt = true;
            }

            if(i < str.length() && str.charAt(i) == 'x'){
                ans[0] += !cnt ? flag : flag * val;
                i ++;
            }else{
                ans[1] += flag * val;
            }
        }

        return ans;
    }
}
