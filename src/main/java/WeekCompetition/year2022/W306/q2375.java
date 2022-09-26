package WeekCompetition.year2022.W306;

public class q2375 {
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern));
    }
    public static String smallestNumber(String pattern) {
        int n = pattern.length();

        char[] chars = new char[n + 1];

        char start = '1';
        int i = 0;

        while (i < n){
            if(i > 0 && pattern.charAt(i) == 'I'){
                i++;
            }

            while(i < n && pattern.charAt(i) == 'I'){
                chars[i] = start;
                start ++;
                i++;
            }

            int i0 = i;
            while(i < n && pattern.charAt(i) == 'D'){
                i ++;
            }

            for(int j  = i; j >= i0; j --){
                chars[j] = start;
                start ++;
            }
        }


        return new String(chars);
    }
}
