package Year2022.Daily.M8.D16;

import java.util.ArrayList;
import java.util.List;

public class q1656 {
}

class OrderedStream {
    String[] store;
    int ptr;
    int n;
    public OrderedStream(int n) {
        store = new String[n + 1];
        ptr =  1;
        this.n = n;
    }

    public List<String> insert(int idKey, String value) {
        store[idKey] = value;

        List<String> ans = new ArrayList<>();
        if(store[ptr] == null){
            return ans;
        }

        while(ptr <= n && store[ptr] != null){
            ans.add(store[ptr]);
            ptr++;
        }

        return ans;


    }
}