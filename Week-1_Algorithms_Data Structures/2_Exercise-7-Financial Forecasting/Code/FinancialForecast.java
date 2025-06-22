public class FinancialForecast {

    public static double calculateFutureValue(double principal, double growthRate, int years) {
        if (years == 0) return principal;
        return (1 + growthRate) * calculateFutureValue(principal, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000;
        double annualGrowthRate = 0.08;
        int forecastYears = 5;

        double result = calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);
        System.out.printf("Projected value after %d years: %.2f\n", forecastYears, result);
    }
}
