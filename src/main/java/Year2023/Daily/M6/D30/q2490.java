package Year2023.Daily.M6.D30;

public class q2490 {
    public boolean isCircularSentence(String sentence) {
        String[] strings = sentence.split(" ");
        int n = strings.length;

        if(strings[n - 1].charAt(strings[n - 1].length() - 1) != strings[0].charAt(0)){
            return false;
        }


        for(int i = 0; i < n - 1; i++){
            if(strings[i].charAt(strings[i].length() - 1) != strings[i + 1].charAt(0)){
                return false;
            }
        }

        return true;
    }
}
