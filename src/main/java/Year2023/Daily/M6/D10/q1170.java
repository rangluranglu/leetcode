package Year2023.Daily.M6.D10;

import java.util.Arrays;

public class q1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 使用queriy 去 words 中查询
        // 预处理wordsi

        int m = queries.length, n = words.length;
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];

            cnt[i] = count(word);
        }
        System.out.println(Arrays.toString(cnt));
        Arrays.sort(cnt);


        int[] ans = new int[m];

        // 二分查找
        for (int i = 0; i < m; i++) {
            ans[i] = biSearch(cnt, count(queries[i]));
        }

        return ans;
    }

    private int biSearch(int[] nums, int tar){
        // 找到第一个大于的index

        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > tar){
                right = mid - 1;
            } else if (nums[mid] < tar) {
                left = mid + 1;
            }else {
                left = mid + 1;
            }
        }

        return left == nums.length ? 0 : nums.length - left;

    }


    private int count(String word){
        // 如何快速统计
        int cnt = 0;
        char ch = 'z';

        for(char c : word.toCharArray()){
            if(c < ch){
                ch = c;
                cnt = 1;
            }else if(c == ch){
                cnt ++;
            }
        }

        return cnt;
    }
}
