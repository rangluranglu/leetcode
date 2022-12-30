package Year2022.Week.W325;

public class q2515 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        int index = startIndex;

        for (int i = 0; i <= n / 2; i++) {
            if(words[(index + i) % n].equals(target) || words[(index - i + n) %  n].equals(target)){
                return i;
            }
        }

        return -1;
    }
}
