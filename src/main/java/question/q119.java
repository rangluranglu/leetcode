package question;

import java.util.ArrayList;
import java.util.List;

public class q119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            ans.add((int) ((long)ans.get(i - 1) * (rowIndex -i + 1) / i));

        }

        return ans;
    }
}
