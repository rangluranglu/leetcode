package WeekCompetition.year2022.W316;

public class q2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = convertMinutes(event1[0]);
        int e1 = convertMinutes(event1[1]);

        int s2 = convertMinutes(event2[0]);
        int e2 = convertMinutes(event2[1]);

        return !(s1 > e2 || s2 > e1);
    }

    public int convertMinutes(String time){
        String[] t = time.split(":");

        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
