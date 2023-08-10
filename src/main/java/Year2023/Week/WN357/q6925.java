package Year2023.Week.WN357;

public class q6925 {
    public String finalString(String s) {
        // 逆序

        if (s.indexOf("i") < 0) {
            return s;
        }

        int index = s.indexOf("i");
        StringBuilder sb = new StringBuilder();

        sb.append(s.substring(0, index));
        return finalString(sb.reverse().toString() + s.substring(index + 1));
    }
}
