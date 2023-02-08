package Year2023.Daily.M2.D8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q1233 {
    List<String> ans = new ArrayList<>();
    String[] folder;
    public List<String> removeSubfolders(String[] folder) {
        // 字典树
        this.folder = folder;
        Trie root = new Trie();
        for(int i = 0; i < folder.length; i++){
            root.addFolder(folder[i], i);
        }
        dfs(root);
        return ans;
    }

    public void dfs(Trie root){
        if(root.index >= 0){
            ans.add(folder[root.index]);
            return;
        }

        for (String key : root.map.keySet()){
            dfs(root.map.get(key));
        }
    }

}

class Trie{

    Map<String, Trie> map;
    int index;

    public Trie(){
        map = new HashMap<>();
        index = -1;
    }

    public void addFolder(String folder, int index){
        Trie root = this;

        String[] split = folder.split("/");
        for(String sub : split){
            if(sub == null || sub.length() == 0){
                continue;
            }

            if(!root.map.containsKey(sub)){
                root.map.put(sub, new Trie());
            }

            root = root.map.get(sub);
            if(root.index > 0){
                return;
            }
        }
        root.index = index;
    }
}
