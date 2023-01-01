package Year2023.Daily.M1.D1;

public class q2351 {

    public char repeatedCharacter(String s) {

        int[] visited = new int[26];

        for(char c : s.toCharArray()){
            if(visited[c - 'a'] == 1){
                return c;
            }

            visited[c - 'a'] ++;
        }

        return 'a';
    }
}
