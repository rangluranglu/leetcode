package Year2023.Daily.M4.D3;

public class q1053 {
    public int[] prevPermOpt1(int[] arr) {
        // 一次交换后、 按字典序排列小于arr的最大排列

        // 要求最大  --> 尽可能交换后面的
        // 如果是非递减
        // 有 arr[i] > arr[j] --> 最大化arr[i]

        int n = arr.length;

        for(int i = n - 2; i >= 0; i--){
            if(arr[i] > arr[i + 1]){
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]){
                    j --;
                }

                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                break;
            }
        }

        return arr;
    }
}
