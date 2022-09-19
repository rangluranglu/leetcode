package WeekCompetition.year2022.W311;

public class q2416 {
    public int[] sumPrefixScores(String[] words) {
        // 字典树
        Trie root = new Trie();
        for(String word : words){
            root.insert(word);
        }
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = root.search(words[i]);
        }

        return ans;

    }

    class Trie {
        Trie[] children;
        int count;

        public Trie() {
            children = new Trie[26];
            count = 0;
        }

        public void insert(String word) {
            Trie root = this;
            for(char ch : word.toCharArray()){
                if(root.children[ch - 'a'] == null){
                    root.children[ch - 'a'] = new Trie();
                }

                root = root.children[ch - 'a'];
                root.count ++;

            }
        }

        public int search(String word){
            Trie root = this;
            int cnt = 0;
            for(char ch : word.toCharArray()){
                if(root.children[ch - 'a'] == null){
                    return cnt;
                }
                root = root.children[ch - 'a'];
                cnt += root.count;
            }

            return cnt;
        }
    }
}
