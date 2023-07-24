package Year2023.Week.WN355;

import java.util.Collections;
import java.util.List;

public class c {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        // 每个组必须由不同数字组成，单个组不存在重复数字
        // 长度必须严格大于前一个

        // 每组增加一个数
        // 从1个数开始
        int n = usageLimits.size();
        Collections.sort(usageLimits);

        int ans = 0, s = 0;
        for (Integer use : usageLimits){
            s += use;
            // 看看是否能构造池ans + 1 组
            if (s >= (ans + 2) * (ans + 1) / 2) {
                ans += 1;
            }
        }

        return ans;


    }
}
