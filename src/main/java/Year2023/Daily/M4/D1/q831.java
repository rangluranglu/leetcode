package Year2023.Daily.M4.D1;

public class q831 {

    String[] country = {"", "+*-", "+**-", "+***-"};
    public String maskPII(String s) {
        // 邮箱
        int at = s.indexOf("@");

        if(at > 0){
            s = s.toLowerCase();
            return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
        }

        s = s.replaceAll("[^0-9]", "");
        return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);

    }
}
