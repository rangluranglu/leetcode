package Year2023.Week.W350;

public class q2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        // 模拟
        return (mainTank + Math.min((mainTank - 1) / 4, additionalTank)) * 10;

    }
}
