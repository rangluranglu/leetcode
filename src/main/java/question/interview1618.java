package question;

public class interview1618 {
    public static void main(String[] args) {
        System.out.println(patternMatching("bb", "ii"));
    }
    public static boolean patternMatching(String pattern, String value) {
        // 计算a, b 个数枚举
        int count_a = 0, count_b = 0;
        for(char ch : pattern.toCharArray()){
            if(ch == 'a'){
                count_a ++;
            }else{
                count_b ++;
            }
        }


        int n = value.length();

        //交换
        if(count_a < count_b){
            int tmp = count_a;
            count_a = count_b;
            count_b = tmp;

            char[] chars = pattern.toCharArray();
            for(int i = 0; i < chars.length; i++){
                chars[i] = chars[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(chars);
        }
        //System.out.println(pattern);
        // a 大 b小
        if(value.length() == 0){
            return count_b == 0;
        }

        if(pattern.length() == 0){
            return false;
        }

        // 开始枚举

        for(int i = 0; i * count_a <= value.length(); i ++){
            if(count_b != 0 && (value.length() - i * count_a) % count_b != 0){
                continue;
            }

            int j = count_b == 0 ? 0 : (value.length() - i * count_a) / count_b;
            if(i == 0 && j == 0) {
                continue;
            }
            int pos = 0;
            //System.out.println(i + "----" + j);
            String value_a = "";
            String value_b = "";
            boolean correct = true;
            for(char ch : pattern.toCharArray()){
                if(ch == 'a'){
                    String sub = value.substring(pos, pos + i);
                    if(value_a.length() == 0){
                        value_a = sub;
                    }else if(!value_a.equals(sub)){
                        correct =false;
                        break;
                    }
                    pos += i;
                }else{
                    String sub = value.substring(pos, pos + j);
                    if(value_b.length() == 0){
                        value_b = sub;
                    }else if(!value_b.equals(sub)){
                        correct = false;
                        break;
                    }
                    pos += j;
                }
            }
            //System.out.println(correct + value_a + "----" + value_b);
            if(correct && !value_a.equals(value_b)){
                return true;
            }

        }
        return false;
    }
}
