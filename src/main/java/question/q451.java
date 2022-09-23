package question;

import java.util.Arrays;

public class q451 {
    public static void main(String[] args) {
        String a = "tree";
        System.out.println(frequencySort(a));
    }
    public static String frequencySort(String s) {
        int[] count = new int[128];

        for (char ch : s.toCharArray()){
            count[ch] ++;
        }
        Integer[] index = new Integer[128];
        for(int i = 0; i < 128; i++){
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> count[b] - count[a]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            int idx = index[i];
            if(count[idx] == 0){
                break;
            }
            for (int j = 0; j < count[idx]; j++) {
                sb.append((char) idx);
            }
        }

        return sb.toString();
    }
}
