package Year2023.Daily.M5.D8;

public class q2437 {
    public int countTime(String time) {
        int countHour = 0, countMinute = 0;

        for (int i = 0; i < 24; i++) {
            int hiH = i / 10;
            int loH = i % 10;

            if((time.charAt(0) == '?' || time.charAt(0)-'0' == hiH) && (time.charAt(1) == '?' || time.charAt(1)-'0' == loH)){
                countHour ++;
            }
        }


        for (int i = 0; i < 60; i++) {
            int hiM = i / 10;
            int loM = i % 10;

            if((time.charAt(3) == '?' || time.charAt(3)-'0' == hiM) && (time.charAt(4) == '?' || time.charAt(4)-'0' == loM)){
                countMinute ++;
            }
        }

        return countHour * countMinute;
    }
}
