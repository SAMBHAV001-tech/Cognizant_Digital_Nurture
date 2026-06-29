public class Main {
    public static void main(String[] args) {
        double principal = 10000;
        double rate = 0.08;

        System.out.println("--- Recursive Financial Forecast ---");
        System.out.println("Principal: " + principal);
        System.out.println("Annual Growth Rate: " + (rate * 100) + "%");
        System.out.println();

        for (int year = 1; year <= 10; year++) {
            double value = Forecast.futureValue(principal, rate, year);
            System.out.printf("Year %2d: %.2f%n", year, value);
        }

        System.out.println("\n--- With Memoization (Year 10) ---");
        double[] memo = new double[11];
        double result = Forecast.futureValueMemo(principal, rate, 10, memo);
        System.out.printf("Future Value after 10 years: %.2f%n", result);
    }
}
