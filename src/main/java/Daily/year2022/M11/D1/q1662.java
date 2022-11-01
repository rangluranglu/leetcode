package Daily.year2022.M11.D1;

public class q1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int x = 0, y = 0;
        int i = 0, j = 0;
        int m = word1.length, n = word2.length;
        while (x != m && y != n){
            if(word1[x].charAt(i) == word2[y].charAt(j)){
                i ++;
                j ++;
            }else {
                return false;
            }

            if(i == word1[x].length()){
                x += 1;
                i = 0;
            }

            if(j == word2[y].length()){
                y +=1;
                j = 0;
            }
        }

        return x == m && y == n;

    }
}
