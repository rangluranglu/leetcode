package question;

import java.util.HashSet;
import java.util.Set;

public class q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }
}
