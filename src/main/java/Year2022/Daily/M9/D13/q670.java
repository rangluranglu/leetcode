package Year2022.Daily.M9.D13;

public class q670 {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIndex = n - 1;
        int idx = -1, idx2 = -1;

        for(int i = n- 1; i >= 0; i--){
            if(charArray[i] > charArray[maxIndex]){
                maxIndex = i;
            }else if(charArray[i] < charArray[maxIndex]){
                idx = i;
                idx2 = maxIndex;
            }
        }

        if(idx >= 0){
            swap(charArray, idx, idx2);
            return Integer.parseInt(new String(charArray));
        }else {
            return num;
        }
    }

    public void swap(char[] charArray, int i, int j){
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
    }
}
