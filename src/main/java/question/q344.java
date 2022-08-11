package question;

public class q344 {
    public void reverseString(char[] s) {
        int n = s.length;

        int l = 0, r = n - 1;

        while(l < r){
            swap(s, l, r);
            l ++;
            r --;
        }
    }

    public void swap(char[] s, int l, int r){
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;

    }
}
