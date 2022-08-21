package WeekCompetition.year2022.W307;

public class q6166 {
    public static void main(String[] args) {
        String num = "00";
        System.out.println(largestPalindromic(num));
    }


    public static String largestPalindromic(String num) {
        int[] count = new int[10];
        int maxSingle = -1;

        for(char ch : num.toCharArray()){
            count[ch - '0'] ++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 9 ; i >= 0; i--){
            if(i != 0 || sb.length() != 0){
                for(int j = 0; j < count[i] / 2; j ++){
                    sb.append(i);
                }
            }
            if(maxSingle == -1 && count[i] % 2 == 1){
                maxSingle = i;
            }
        }

        if(maxSingle == -1){
            return sb.length() == 0 ? "0" : sb.toString() + sb.reverse().toString();
        }


        return sb.toString() + String.valueOf(maxSingle) + sb.reverse().toString();
    }
}
