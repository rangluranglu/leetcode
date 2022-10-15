package Daily.year2022.M10.D15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class q1441 {
    public List<String> buildArray(int[] target, int n) {
        int length = target.length;
        int index = 0;
        List<String> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(index == length){
                break;
            }
            if(target[index] == i){
                ans.add("Push");
                index ++;
            }else{
                ans.add("Push");
                ans.add("Pop");
            }
        }

        return ans;
    }
}
