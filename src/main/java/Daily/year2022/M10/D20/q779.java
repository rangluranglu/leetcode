package Daily.year2022.M10.D20;

public class q779 {
    public int kthGrammar(int n, int k) {
        // 规律： 每一行的后半部分正好为前半部分的“翻转”
        if(n == 1){
            return 0;
        }

        if(k > (1 << (n - 1))){
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }

        return kthGrammar(n - 1, k);
    }
    public int kthGrammar2(int n, int k) {
        // 规律： 每一行的后半部分正好为前半部分的“翻转”
        return Integer.bitCount(k - 1) & 1;
    }


}
