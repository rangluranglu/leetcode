package Year2022.Week.W303;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class q2353 {


}

class FoodRatings {
    Map<String, Queue<Food>> map;
    Map<String, Food> nameMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        nameMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++){
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            map.computeIfAbsent(cuisines[i], x -> new PriorityQueue<>((a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : b.rating - a.rating)).offer(food);
            nameMap.put(foods[i], food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food oldFood = nameMap.get(food);
        Queue<Food> foods = map.get(oldFood.cuisune);
        foods.remove(oldFood);
        oldFood.rating = newRating;
        foods.offer(oldFood);
    }

    public String highestRated(String cuisine) {
        Queue<Food> foods = map.get(cuisine);
        return foods.peek().name;
    }


    class Food{
        String name;
        String cuisune;
        int rating;

        public Food(String name, String cuisune, int rating){
            this.name = name;
            this.cuisune = cuisune;
            this.rating = rating;
        }
    }
}
