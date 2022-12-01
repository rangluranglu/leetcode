package WeekCompetition.year2022.DW88;

public class q2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        int n = nums1.length;
        int m = nums2.length;

        for(int num : nums1){
            sum1 ^= num;
        }
        for(int num : nums2){
            sum2 ^= num;
        }

        if(m % 2 == 0 && n % 2 == 0){
            return 0;
        }

        if(m % 2 == 0 || n % 2 == 0){
            if(m % 2 == 1){
                return sum1;
            }
            return sum2;
        }

        return sum1 ^ sum2;
    }
}
