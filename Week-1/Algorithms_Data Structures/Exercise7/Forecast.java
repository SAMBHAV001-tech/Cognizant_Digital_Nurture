public class Forecast {

    public static double futureValue(double amount, double rate, int years) {
        if (years == 0) {
            return amount;
        }
        return futureValue(amount * (1 + rate), rate, years - 1);
    }

    public static double futureValueMemo(double amount, double rate, int years, double[] memo) {
        if (years == 0) {
            return amount;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = futureValueMemo(amount * (1 + rate), rate, years - 1, memo);
        return memo[years];
    }
}
