package Year2022.Daily.M11.D6;

public class q1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); ) {
            if(command.charAt(i) == 'G'){
                sb.append('G');
                i++;
            }else if(command.charAt(i) == '('){
                if(command.charAt(i + 1) == 'a'){
                    sb.append("al");
                    i += 4;
                }else {
                    sb.append("o");
                    i += 2;
                }
            }
        }

        return sb.toString();
    }
}
