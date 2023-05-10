package Year2023.Week.DW98;

public class q2566 {
    public int minMaxDifference(int num) {
        int mx = num;
        String nums = String.valueOf(num);

        for (int i = 0; i < nums.length(); i++) {
            if(nums.charAt(i) != '9'){
                mx = Integer.valueOf(nums.replace(nums.charAt(i), '9'));
                break;
            }
        }

        return mx - Integer.valueOf(nums.replace(nums.charAt(0), '0'));

    }
}
