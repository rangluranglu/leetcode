package Daily.year2022.M8.D21;

public class q1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] word = sentence.split(" ");
        int len = searchWord.length();


        for (int i = 0; i < word.length; i++) {
            if(word[i].length() < len){
                continue;
            }else if(word[i].substring(0, len).equals(searchWord)){
                return i + 1;
            }

        }

        return -1;
    }
}
