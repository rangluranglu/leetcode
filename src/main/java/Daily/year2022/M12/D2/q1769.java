package Daily.year2022.M12.D2;

public class q1769 {
    public int[] minOperations(String boxes) {
        int left = boxes.charAt(0) - '0';
        int right = 0;
        int operations = 0;

        for (int i = 1; i < boxes.length(); i++) {
            if(boxes.charAt(i) == '1'){
                right ++;
                operations += i;
            }
        }

        int[] ans = new int[boxes.length()];
        ans[0] = operations;

        for (int i = 1; i < boxes.length(); i++) {
            operations += (left - right);
            if(boxes.charAt(i) == '1'){
                left ++;
                right --;
            }

            ans[i] = operations;
        }

        return ans;
    }
}
