package WeekCompetition.year2022.W307;

public class q6152 {
    public static void main(String[] args) {
        int[] energy = {1, 4, 3, 2};
        int[] experince = {2,6,3,1};

        System.out.println(minNumberOfHours(5, 3, energy, experince));
    }
    public static  int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            // 计算经验
            if(initialExperience <= experience[i]){
                ans += ( -initialExperience + experience[i] + 1);
                initialExperience += (experience[i] * 2 - initialExperience + 1);
            }else{
                initialExperience += experience[i];
            }

            sum += energy[i];
        }
        if(initialEnergy > sum){
            return  ans;
        }else{
            ans += (sum - initialEnergy + 1);
        }
        return ans;
    }
}
