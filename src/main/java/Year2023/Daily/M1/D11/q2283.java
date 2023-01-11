package Year2023.Daily.M1.D11;

public class q2283 {
    public boolean digitCount(String num) {
        int[] count = new int[10];

        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0'] ++;
        }

        for (int i = 0; i < num.length(); i++) {
            if(count[i] != num.charAt(i) - '0'){
                return false;
            }
        }

        return true;
    }
}
