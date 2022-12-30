package Year2022.Week.DW88;

import java.util.HashSet;
import java.util.Set;

public class q2424 {
}


class LUPrefix {
    // 最长前缀不会变小

    Set<Integer> set;
    int x;
    public LUPrefix(int n) {
        set = new HashSet<>();
        x = 1;
    }

    public void upload(int video) {
        set.add(video);
    }

    public int longest() {
        while (set.contains(x)){
            x += 1;
        }

        return x - 1;
    }
}