package Daily.year2022.M8.D7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class q636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ret = new int[n];

        Deque<int[]> stack = new LinkedList<>();

        for(String log : logs){
            String[] l = log.split(":");
            int index = Integer.parseInt(l[0]);
            int time = Integer.parseInt(l[2]);

            if("start".equals(l[1])){
                if(!stack.isEmpty()){
                    ret[stack.peek()[0]] += time - stack.peek()[1];
                    stack.peek()[1] = time;
                }

                stack.push(new int[]{index, time});
            }else{
                int[] t = stack.pop();
                ret[t[0]] += time - t[1] + 1;
                if(!stack.isEmpty()){
                    stack.peek()[1] = time + 1;
                }
            }
        }

        return ret;


    }
}
