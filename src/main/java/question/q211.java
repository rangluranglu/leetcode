package question;

public class q211 {

}
class WordDictionary {
    // 匹配.

    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
       return search(root, word, 0);
    }

    public boolean search(Trie root, String word, int index){
        if(index == word.length()){
            return root.end;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null && search(root.children[i], word, index + 1)) {
                    return true;
                }
            }
        } else {
            if (root.children[ch - 'a'] != null && search(root.children[ch - 'a'], word, index + 1)) {
                return true;
            }
        }

        return false;
    }
}

class Trie{
    Trie[] children;
    boolean end;

    public Trie(){
        children = new Trie[26];
        end = false;
    }

    public void insert(String word){
        Trie root = this;
        for(char ch : word.toCharArray()){
            if(root.children[ch - 'a'] == null){
                root.children[ch - 'a'] = new Trie();
            }
            root = root.children[ch - 'a'];
        }
        root.end = true;
    }


}
