import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded exchange rates
        Map<String, Map<String, Double>> exchangeRates = new HashMap<>();

        // Exchange rates relative to USD
        Map<String, Double> usdRates = new HashMap<>();
        usdRates.put("EUR", 0.85);
        usdRates.put("GBP", 0.75);
        usdRates.put("JPY", 110.0);
        usdRates.put("AUD", 1.35);
        usdRates.put("INR", 74.0);  // USD to INR
        exchangeRates.put("USD", usdRates);

        // Exchange rates relative to EUR
        Map<String, Double> eurRates = new HashMap<>();
        eurRates.put("USD", 1.18);
        eurRates.put("GBP", 0.88);
        eurRates.put("JPY", 129.0);
        eurRates.put("AUD", 1.59);
        eurRates.put("INR", 87.0);  // EUR to INR
        exchangeRates.put("EUR", eurRates);

        // Exchange rates relative to GBP
        Map<String, Double> gbpRates = new HashMap<>();
        gbpRates.put("USD", 1.33);
        gbpRates.put("EUR", 1.14);
        gbpRates.put("JPY", 146.0);
        gbpRates.put("AUD", 1.80);
        gbpRates.put("INR", 99.0);  // GBP to INR
        exchangeRates.put("GBP", gbpRates);

        // Exchange rates relative to INR
        Map<String, Double> inrRates = new HashMap<>();
        inrRates.put("USD", 0.013); // INR to USD
        inrRates.put("EUR", 0.011); // INR to EUR
        inrRates.put("GBP", 0.010); // INR to GBP
        inrRates.put("JPY", 1.46);   // INR to JPY
        inrRates.put("AUD", 0.018);  // INR to AUD
        exchangeRates.put("INR", inrRates);

        // Select base currency
        System.out.print("Select base currency (USD, EUR, GBP, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency)) {
            System.out.println("Base currency not supported.");
            return;
        }

        // Select target currency
        System.out.print("Enter target currency (USD, EUR, GBP, JPY, AUD, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.get(baseCurrency).containsKey(targetCurrency)) {
            System.out.println("Target currency not supported.");
            return;
        }

        // Input amount
        System.out.print("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        // Perform conversion
        double exchangeRate = exchangeRates.get(baseCurrency).get(targetCurrency);
        double convertedAmount = convertCurrency(amount, exchangeRate);
        displayResult(convertedAmount, targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    private static void displayResult(double convertedAmount, String targetCurrency) {
        System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
    }
}
