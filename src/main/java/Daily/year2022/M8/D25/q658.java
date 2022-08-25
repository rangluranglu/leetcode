package Daily.year2022.M8.D25;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 特例
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        // 二分
        int left = 0, right = n - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= x){
                right --;
            }else{
                left ++;
            }
        }
        //System.out.println(left);
        int l = left - 1, r = left;

        while(k -- > 0){
            if(l < 0){
                r ++;
            }else if(r >= n){
                l --;
            }else if ( x - arr[l] <= arr[r] - x){
                l --;
            }else{
                r ++;
            }
        }

        for (int i = l + 1; i < r; i++) {
            ans.add(arr[i]);
        }
        return ans;

    }
}
