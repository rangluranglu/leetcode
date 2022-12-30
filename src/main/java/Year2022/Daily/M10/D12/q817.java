package Year2022.Daily.M10.D12;

import Common.ListNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class q817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = 0;
        boolean pre = false;
        while (head != null){
            if (set.contains(head.val)){
                if(!pre){
                    ans += 1;
                }
                pre = true;
            }else {
                pre = false;
            }
            head = head.next;
        }

        return ans;

    }
}
