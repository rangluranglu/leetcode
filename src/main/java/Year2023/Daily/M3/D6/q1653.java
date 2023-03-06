package Year2023.Daily.M3.D6;

public class q1653 {
    public int minimumDeletions(String s) {


        // 要求： a 全部在b前面
        // 三种情况： 全为a, 全为b， a在b左侧
        // 枚举间隔，删除前面的b和后面的a

        int n = s.length();

        int leftb = 0, righta = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a'){
                righta ++;
            }
        }

        int res = righta;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == 'a'){
                righta --;
            }else {
                leftb ++;
            }

            res = Math.min(res, leftb + righta);
        }

        return  res;


    }
}
