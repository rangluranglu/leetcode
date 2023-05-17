package Year2023.Daily.M5.D17;

public class q2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int a0 = transMinute(event1[0]);
        int a1 = transMinute(event1[1]);

        int b0 = transMinute(event2[0]);
        int b1 = transMinute(event2[1]);


        return !(a0 > b1 || b0 > a1);
    }

    private int transMinute(String time){

        String[] times = time.split(":");

        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
