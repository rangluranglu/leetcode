package Year2023.Daily.M7.D5;

public class q2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k <= numOnes + numZeros){
            return Math.min(k, numOnes);
        }

        return numOnes -(k - numZeros - numOnes);
    }
}
