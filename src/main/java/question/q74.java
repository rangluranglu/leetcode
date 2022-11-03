package question;

public class q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分查找
        // 展开成以为数组是升序数组，
         int m = matrix.length;
         int n = matrix[0].length;
         int low = 0, high = m * n - 1;

         while(low <= high){
             int mid = low + (high - low) / 2;

             if(matrix[mid / n][mid % n] > target){
                 high = mid - 1;
             }else if(matrix[mid / n][mid % n] < target){
                 low = mid + 1;
             }else{
                 return true;
             }
         }

         return false;
    }

}
