package Year2023.Week.W343;

public class q2660 {
    public int isWinner(int[] player1, int[] player2) {


        int a = player1[0], b = player2[0];
        int n = player1.length;
        if(n == 1){
            return  b > a ? 2 : ((b < a) ? 1 : 0);
        }
        for(int i = n - 1; i >= 2; i--){
            if(player1[i - 1] == 10 || player1[i - 2] == 10){
                a += player1[i];
            }
            a += player1[i];
            if(player2[i - 1] == 10 || player2[i - 2] == 10){
                b += player2[i];
            }
            b += player2[i];
        }

        if(player1[0] == 10){
            a += player1[1] ;
        }
        a += player1[1];

        if(player2[0] == 10){
            b += player2[1] ;
        }
        b += player2[1];
        System.out.println(a);
        System.out.println(b);
        return  b > a ? 2 : ((b < a) ? 1 : 0);
    }
}
