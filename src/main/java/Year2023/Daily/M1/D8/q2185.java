package Year2023.Daily.M1.D8;

public class q2185 {
    public int prefixCount(String[] words, String pref) {
        int a = 0;
        for(String word : words){
            if(word.indexOf(pref) == 0) a ++;
        }

        return a;
    }
}
