package Year2023.Daily.M3.D13;

public class q2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;

        int tEnergy = 0, tExperience = 0;
        for (int i = 0; i < n; i++) {
            tEnergy += energy[i];

            if(initialExperience <= experience[i]){
                tExperience += 1 + (experience[i] - initialExperience);
                initialExperience = experience[i] * 2 + 1;
            }else {
                initialExperience += experience[i];
            }
        }


        int a = initialEnergy > tEnergy ? 0 : tEnergy + 1 - initialEnergy;

        return a + tExperience;

    }
}
