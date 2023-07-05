package Year2023.Week.DW104;

public class q2678 {
    public int countSeniors(String[] details) {
        int ans = 0;

        for(String de : details){
            if(Integer.valueOf(de.substring(11, 13)) > 60){
                ans ++;
            }
        }

        return ans;
    }
}
