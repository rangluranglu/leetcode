package Year2023.Daily.M3.D14;

public class q1032 {
}

class StreamChecker {

    // 字符流中的后缀是否为words中的
    // 前缀树 --> 将word 反转后插入前缀树
    private Trie trie = new Trie();
    private StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words){
            trie.insert(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);

        return trie.query(sb);
    }
}

class Trie{
    Trie[] children = new Trie[26];
    boolean isEnd = false;

    public void insert(String w){
        Trie root = this;

        for (int i = w.length() - 1; i >= 0; i--){
            int idx = w.charAt(i) - 'a';

            if(root.children[idx] == null){
                root.children[idx] = new Trie();
            }
            root = root.children[idx];
        }
        root.isEnd = true;
    }

    public boolean query(StringBuilder s){
        Trie root = this;
        for (int i = s.length() - 1, j = 0; i >= 0 && j < 201; i--, j++){
            int idx = s.charAt(i) - 'a';
            if(root.children[idx] == null){
                return false;
            }

            root = root.children[idx];
            if(root.isEnd){
                return true;
            }
        }

        return false;

    }
}