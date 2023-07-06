package Year2023.Daily.M7.D6;

import java.util.ArrayList;
import java.util.List;

public class q2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        // 不同的正偶数之和，偶数数目最多
        // 贪心 --> 从小到大枚举


        if(finalSum % 2 == 1){
            return  new ArrayList<>();
        }

        List<Long> ans = new ArrayList<>();
        // 偶数计算前n项之和， 首相是2， 公差是2，
        long sum = 2, i = 2;
        for (i = 2; sum <= finalSum; i += 2,sum += i) {
            ans.add(i);
        }


        if(sum > finalSum){
            ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum - sum + i);
        }
        return ans;
    }

    public List<Long> maximumEvenSplit2(long finalSum) {
        // 不同的正偶数之和，偶数数目最多
        // 贪心 --> 从小到大枚举


        // 更简洁的写法，
        List<Long> ans = new ArrayList<>();
        if(finalSum % 2 == 1){
            return ans;
        }

        // 偶数计算前n项之和， 首相是2， 公差是2，
        for(long i = 2; i <= finalSum; i += 2){
            ans.add(i);
            finalSum -= i;
        }

        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
        return ans;
    }
}
