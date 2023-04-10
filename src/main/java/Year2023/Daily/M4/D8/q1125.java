package Year2023.Daily.M4.D8;

import com.sun.prism.shader.Solid_TextureRGB_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class q1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        // 动态规划 状态压缩
        // dp[i] 来表示状态，状态含义是满足技能集合为 i 的最小人数的数组。
        int n = req_skills.length, m = people.size();

        HashMap<String, Integer> skill_index = new HashMap<>();

        // 状态压缩
        for (int i = 0; i < n; i++) {
            skill_index.put(req_skills[i], i);
        }


        List<Integer>[] dp = new List[1 << n];

        dp[0] = new ArrayList<>();

        for (int i = 1; i < m; i++) {
            int cur_skill = 0;
            for(String skill : people.get(i)){
                cur_skill |= 1 << skill_index.get(skill);
            }

            for(int prev = 0; prev < dp.length; prev ++){
                if(dp[prev] == null){
                    continue;
                }

                int comb = prev | cur_skill;
                if(dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()){
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }

        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();

    }


    public int[] smallestSufficientTeam2(String[] req_skills, List<List<String>> people) {
        // 动态规划 状态压缩, 优化

        // dp[i] 满足技能集合为 i 的最小人数
        // prev_skill[i] 表示技能的转移
        // prev_people[i] 表示新加入的员工
        int n = req_skills.length, m = people.size();

        HashMap<String, Integer> skill_index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skill_index.put(req_skills[i], i);
        }

        int[] dp = new int[1 << n];
        Arrays.fill(dp, m);
        dp[0] = 0;

        int[] prev_skill = new int[1 << n];
        int[] prev_people = new int[1 << n];

        for (int i = 0; i < m; i++) {
            List<String> p = people.get(i);
            int cur_skill = 0;
            for (String s : p) {
                cur_skill |= 1 << skill_index.get(s);
            }

            for(int prev = 0; prev < (1 << n); prev++){
                int comb = cur_skill | prev;
                if(dp[comb] > dp[prev] + 1){
                    dp[comb] = dp[prev] + 1;
                    prev_skill[comb] = prev;
                    prev_people[comb] = i;
                }

            }
        }

        List<Integer> res = new ArrayList<>();
        int i = (1 << n) - 1;
        while (i > 0){
            res.add(prev_people[i]);
            i = prev_skill[i];
        }

        return res.stream().mapToInt(j -> j).toArray();

    }
}
