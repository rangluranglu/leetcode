package Daily.year2022.M10.D23;

public class q1768 {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        StringBuilder  sb = new StringBuilder();
        while(i < m || i < n){
            if(i < word1.length()){
                sb.append(word1.charAt(i));
            }

            if(i < word2.length()){
                sb.append(word2.charAt(i));
            }

            i++;
        }
        return sb.toString();
    }
}
