package question;

import java.util.*;

public class q726 {
    int i, n;
    String formula;
    public String countOfAtoms(String formula) {
        // 栈
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<String, Integer>());

        this.i = 0;
        this.n = formula.length();
        this.formula = formula;

        while(i < n){
            char ch = formula.charAt(i);
            switch (ch){
                case '(':
                    i ++;
                    stack.push(new HashMap<>());
                    break;

                case ')':
                    i++;
                    int num = parseNum();

                    Map<String, Integer> popMap = stack.pop();
                    Map<String, Integer> topMap = stack.peek();

                    for(Map.Entry<String, Integer> entry : popMap.entrySet()){
                        String atom = entry.getKey();
                        topMap.put(atom, topMap.getOrDefault(atom, 0) + entry.getValue() * num);
                    }
                    break;
                default:
                    String atom = parseAtom();
                    int num1 = parseNum();
                    Map<String, Integer> topMap1 = stack.peek();
                    topMap1.put(atom, topMap1.getOrDefault(atom, 0) + num1);
            }
        }

        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry : treeMap.entrySet()){
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if(count > 1){
                sb.append(count);
            }
        }

        return sb.toString();

    }


    public String parseAtom(){
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(i));
        i++;
        while(i < n && Character.isLowerCase(formula.charAt(i))){
            sb.append(formula.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public int parseNum(){
        if(i == n || !Character.isDigit(formula.charAt(i))){
            return 1;
        }
        int num = 0;

        while(i < n && Character.isDigit(formula.charAt(i))){
            num = num * 10 + formula.charAt(i) - '0';
            i ++;
        }

        return num;
    }
}
