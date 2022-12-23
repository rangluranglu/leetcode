package Daily.year2022.M12.D23;

public class q2011 {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for(String o : operations){
            x += o.charAt(0) == '+' || o.charAt(2) == '+' ? 1 :-1;
        }

        return x;
    }
}
