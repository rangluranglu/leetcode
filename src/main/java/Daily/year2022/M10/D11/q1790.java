package Daily.year2022.M10.D11;

public class q1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();

        int a = -1, b = -1;
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(b != -1){
                    return false;
                }
                if(a != -1){
                    b = a;
                }

                a = i;


            }
        }
        if(a == -1 && b == -1){
            return true;
        }

        if(a == -1 || b == -1){
            return false;
        }
        if(s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a)){
            return true;
        }

        return false;
    }
}
