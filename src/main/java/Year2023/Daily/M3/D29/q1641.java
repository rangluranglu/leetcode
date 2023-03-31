package Year2023.Daily.M3.D29;

public class q1641 {
    public int countVowelStrings(int n) {
        // 隔板法 c(n + 4, 4)
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
}
