package Year2023.Week.DW95;

public class q2525 {
    int maxL = (int)1e4;
    int maxV = (int)1e9;
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;

        long v = (long) length * width *height;
        if(length >= maxL || width >= maxL || height >= maxL || v >= maxV){
            isBulky = true;
        }

        boolean isHeavy = mass >= 100;


        if(isBulky && isHeavy)  return "Both";
        if(isBulky) return "Bulky";
        if(isHeavy) return "Heavy";
        return "Neither";
    }
}
