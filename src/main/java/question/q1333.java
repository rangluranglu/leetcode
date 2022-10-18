package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> restaurantList = new ArrayList<int[]>();

        for(int[] rest : restaurants){
            if((rest[2] == 1 || veganFriendly == 0) && rest[3] <= maxPrice && rest[4] <= maxDistance){
                restaurantList.add(new int[]{rest[0], rest[1]});
            }
        }

        Collections.sort(restaurantList, (a, b) -> {
            if(a[1] != b[1]){
                return b[1] - a[1];
            }else{
                return b[0] - a[0];
            }
        });

        List<Integer> ans = new ArrayList<>();
        for(int[] restaurant : restaurantList){
            ans.add(restaurant[0]);
        }
        return ans;
    }
}
