package Year2022.Daily.M9.D9;

public class q1598 {
    public int minOperations(String[] logs) {
        // 简单模拟题
        int level = 0;

        for(String log : logs){
            if(log.equals("./")){
                continue;
            }else if(log.equals("../")){
                if(level > 0){
                    level --;
                }
            }else{
                level ++;
            }
        }

        return Math.max(level, 0);
    }
}
