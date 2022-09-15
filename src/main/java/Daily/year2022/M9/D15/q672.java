package Daily.year2022.M9.D15;

public class q672 {
    public int flipLights(int n, int presses) {
        // 共有 4 ^ presses 次按动选择
        // 顺序不影响结果， 奇偶次数影响结果
        // 找规律题

         if(presses == 0){
             return 1;
         }

         if(n == 1){
             return 2;
         }else if(n == 2){
             return  presses == 1 ? 3 : 4;
         }else{
             // n >= 3
             return presses == 1 ? 4 : presses == 2 ? 7 : 8;
         }
    }
}
