package Year2022.Daily.M8.D1;

public class q1374 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();

        if(n % 2 == 0){
            for(int i = 0; i < n; i++){
                sb.append('a');
            }
        }else{
            for(int i = 0; i < n - 1; i++){
                sb.append('a');
            }
            sb.append('b');
        }

        return sb.toString();
    }
}
