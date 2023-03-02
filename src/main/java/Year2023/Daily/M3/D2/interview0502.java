package Year2023.Daily.M3.D2;

public class interview0502 {
    public String printBin(double num) {
        // 小数的二进制转换 0 到 1

        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0){
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }

        return sb.length() <= 32 ? sb.toString() : "ERROR";


    }
}
