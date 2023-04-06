package Year2023.Week.W338;

public class q2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k <= numOnes + numZeros){
            return Math.min(k, numOnes);
        }else {
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
