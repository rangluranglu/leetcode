package question;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class q539 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);

        int ans = Integer.MAX_VALUE;
        int start = getMinutes(timePoints.get(0));
        int preMinutes = start;
        for (int i = 1; i < timePoints.size(); i++){
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes);
            preMinutes = minutes;
        }

        ans = Math.min(ans, start + 1440 - preMinutes);
        return ans;
    }

    public int getMinutes(String t){
        String[] ts = t.split(":");
        return Integer.valueOf(ts[0]) * 60 + Integer.valueOf(ts[1]);
    }

    public int findMinDifference2(List<String> timePoints) {
        // 鸽巢原理
        // 根据题意，一共有 24 x 60=144024×60=1440 种不同的时间。由鸽巢原理可知，如果 timePoints 的长度超过 1440，那么必然会有两个相同的时间，此时可以直接返回 0。
        int n = timePoints.size();
        if(n > 1440){
            return 0;
        }
        Collections.sort(timePoints);

        int ans = Integer.MAX_VALUE;
        int start = getMinutes(timePoints.get(0));
        int preMinutes = start;
        for (int i = 1; i < timePoints.size(); i++){
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes);
            preMinutes = minutes;
        }

        ans = Math.min(ans, start + 1440 - preMinutes);
        return ans;
    }
}
