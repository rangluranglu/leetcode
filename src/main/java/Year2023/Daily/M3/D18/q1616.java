package Year2023.Daily.M3.D18;

public class q1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        // 相同的下标分开
        // a = aprefix + asuffix
        // aprefix + bsuffix 或 bprefix + asuffix 是否回文串

        // 题意理解 ： ai == b[i-1] || b[i] == a[i-1]

        // 双指针
        return checkConcatenation(a, b) || checkConcatenation(b, a);
    }

    public boolean checkConcatenation(String a, String b){
        int n = a.length();

        int i = 0, j = n - 1;

        while (i < j && a.charAt(i) == b.charAt(j)){
            i ++;
            j--;
        }

        if(i >= j){
            return true;
        }

        return checkSelfPalindorme(a, i, j) || checkSelfPalindorme(b, i, j);
    }

    public boolean checkSelfPalindorme(String a, int i, int j){
        while (i < j && a.charAt(i) == a.charAt(j)){
            i ++;
            j --;
        }

        return i >= j;
    }
}
