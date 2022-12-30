package Year2022.Daily.M10.D1;

public class q1694 {
    public String reformatNumber(String number) {
        number = number.replace(" ", "");
        number = number.replace("-", "");

        int n = number.length();
        int remain = n % 3;
        int res = n / 3;
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(i = 0; i < res * 3; i++){
            sb.append(number.charAt(i));
            if(i != n - 1 && i % 3 == 2){
                sb.append("-");
            }
        }

        //System.out.println(sb.toString());

        if(remain == 0){
            sb.append(number.substring(i));
        }else if(remain == 2){
            sb.append(number.substring(i));
        }
        else {
            char ch= sb.charAt(sb.length() - 2);
            sb.deleteCharAt(sb.length() - 2);
            sb.append(ch);
            sb.append(number.substring(i ));
        }

        return sb.toString();
    }

}
