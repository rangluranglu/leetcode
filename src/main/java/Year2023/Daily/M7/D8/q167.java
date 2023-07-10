package Year2023.Daily.M7.D8;

public class q167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i + 1, j + 1};
            }else if(numbers[i] + numbers[j] < target){
                i ++;
            }else {
                j ++;
            }
        }

        return new int[0];
    }
}
