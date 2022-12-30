package Year2022.Week.W317;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2456 {
    class Video{
        long total;
        int maxView;
        String maxId;

        public Video(){
            total = 0L;
            maxView = -1;
        }

    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Video> map = new HashMap<>();
        long n = creators.length;
        long max = -1;
        for (int i = 0; i < n; i++) {
            Video video = map.computeIfAbsent(creators[i], a ->new Video());

            video.total += views[i];
            max = Math.max(max, video.total);

            if(views[i] > video.maxView){
                video.maxView = views[i];
                video.maxId = ids[i];
            }else if(views[i] == video.maxView && ids[i].compareTo(video.maxId) < 0){
                video.maxId = ids[i];
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, Video> entry : map.entrySet()) {
            if(entry.getValue().total == max){
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(entry.getValue().maxId);
                ans.add(list);
            }
        }

        return ans;
    }
}
