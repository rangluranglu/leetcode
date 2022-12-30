package Year2022.Week.W323;

import java.util.Arrays;

public class q2502 {
}

// 暴力模拟
class Allocator {


    int[] arr;
    int n;
    // 大小为n
    public Allocator(int n) {
        arr = new int[n];
        this.n = n;
    }

    // 分配size 大小的内存  mID
    public int allocate(int size, int mID) {
        // 分配内存
        int i = 0;
        int cnt = 0;

        // 找到长度位 size 的空位， 并填充mID
        while (i < n && cnt < size){
            if(arr[i ++] == 0){
                cnt ++;
            }else {
                cnt = 0;
            }
        }

        if(cnt < size){
            return -1;
        }

        Arrays.fill(arr, i - size, i, mID);

        return i - size;
    }

    // 释放内存
    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == mID){
                cnt ++;
                arr[i] = 0;
            }
        }

        return cnt;
    }
}