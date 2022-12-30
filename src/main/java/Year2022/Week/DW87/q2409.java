package Year2022.Week.DW87;

public class q2409 {
    int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] start = arriveAlice.compareTo(arriveBob) < 0 ? arriveBob.split("-") : arriveAlice.split("-");
        String[] end = leaveAlice.compareTo(leaveBob) < 0 ?  leaveAlice.split("-") : leaveBob.split("-");
        int day1 = count(Integer.valueOf(start[0]), Integer.valueOf(start[1]));
        int day2 = count(Integer.valueOf(end[0]), Integer.valueOf(end[1]));
        return day2 - day1 + 1 < 0 ? 0 : day2 - day1 + 1;
    }

    private int count(Integer month, Integer day) {
        int ans = 0;
        for(int i = 1; i < month; i++){
            ans += months[i];
        }
        ans += day;

        return ans;
    }
}
