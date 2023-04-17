package Year2023.Daily.M4.D16;

import java.util.*;

public class q1157 {
}

class MajorityChecker {

    // 随机化 + 二分查找 threshold > 半数

    public static final  int K = 20;
    private int[] arr;

    private Map<Integer, List<Integer>> loc;

    private Random random;
    public MajorityChecker(int[] arr) {
        this.arr = arr;

        this.loc = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            loc.putIfAbsent(arr[i], new ArrayList<>());
            loc.get(arr[i]).add(i);
        }

        this.random = new Random();
    }

    public int query(int left, int right, int threshold) {
        // 查找
        int length = right - left + 1;

        // 选20次·
        for (int i = 0; i < K; i++) {
            int x = arr[left + random.nextInt(length)];
            List<Integer> pos = loc.get(x);

            int occ = searchEnd(pos, right) - searchStart(pos, left);

            if(occ >= threshold){
                return x;
            }else if(occ * 2 >= left){
                return -1;
            }
        }

        return -1;
    }

    public int searchEnd(List<Integer> pos, int target){
        // 查找末尾

        int low = 0, high = pos.size();
        // [)
        while (low < high){
            int mid = low + (high - low) / 2;
            if(pos.get(mid) >= target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


    public int searchStart(List<Integer> pos, int target){
        int low = 0, high = pos.size();
        // [)
        while (low < high){
            int mid = low + (high - low) / 2;
            if(pos.get(mid) > target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


}

