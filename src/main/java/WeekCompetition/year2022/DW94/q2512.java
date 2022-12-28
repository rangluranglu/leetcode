package WeekCompetition.year2022.DW94;

import java.util.*;
import java.util.stream.Collectors;

public class q2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int n = report.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        Set<String> pos = Arrays.stream(positive_feedback).collect(Collectors.toSet());
        Set<String> neg = Arrays.stream(negative_feedback).collect(Collectors.toSet());

        for (int i = 0; i < n; i++) {
            // k名学生
            // 计算分数
            String[] words = report[i].split(" ");
            int score = 0;

            for (String word : words){
                if(pos.contains(word)){
                    score += 3;
                }
                if(neg.contains(word)){
                    score --;
                }
            }

            // k名
            pq.offer(new int[]{student_id[i], score});
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()){
            ans.add(pq.poll()[0]);
        }

        Collections.reverse(ans);
        return ans;


    }
}
