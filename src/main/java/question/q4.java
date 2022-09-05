package question;

public class q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 常规双指针
        int m = nums1.length;
        int n = nums2.length;

        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;

        for (int i = 0; i <= len/2; i++) {
            left = right;
            if(aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart ++];
            }else{
                right = nums2[bStart ++];
            }
        }
        if((len & 1) == 0)
            return (right + left) / 2.0;
        else{
            return right;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // 二分 O(m + n)
        // 转化成寻找两个有序数组中的第 k 小的数
        int length1 = nums1.length, length2 = nums2.length;

        int totalLength = length1 + length2;
        if(totalLength % 2 == 1){
            int midIndex = totalLength / 2;
            double median = getKth(nums1, nums2, midIndex + 1);
            return median;
        }else {
            int midIndex = totalLength / 2 - 1;
            int midIndex2 = totalLength / 2;
            double median = getKth(nums1, nums2, midIndex + 1) + getKth(nums1, nums2, midIndex2 + 1) / 2.0;
            return median;
        }

    }

    private double getKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true){
            if(index1 == m){
                return nums2[index2 + k - 1];
            }
            if(index2 == n){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, m) - 1;
            int newIndex2 = Math.min(index2 + half, n) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
