package WeekCompetition.year2022.W308;

public class q2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] metal = new int[n];
        int[] glass = new int[n];
        int[] paper = new int[n];

        for (int i = 0; i < n; i++) {
            String ans = garbage[i];
            for(char ch : ans.toCharArray()){
                if(ch == 'M'){
                    metal[i] ++;
                }else if(ch == 'G'){
                    glass[i] ++;
                }else{
                    paper[i] ++;
                }
            }
        }

        return help(metal, travel) + help(glass, travel) + help(paper, travel);
    }

    int help(int[] garbage, int[] travel){
        int n = garbage.length;
        int ans = 0;
        for(int i = n - 1; i >= 0; i--){
            if(ans == 0 && garbage[i] == 0){
                continue;
            }

            ans += garbage[i];
            if(i > 0){
                ans += travel[i - 1];
            }
        }

        return ans;
    }

}
