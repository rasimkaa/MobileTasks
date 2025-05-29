import java.text.DecimalFormat;

public class CurrencyConverter {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    // Основной метод конвертации
    public static double convert(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    // Конвертация с форматированием результата
    public static String convertAndFormat(double amount, double exchangeRate) {
        double result = convert(amount, exchangeRate);
        return formatAmount(result);
    }

    // Форматирование суммы для отображения
    public static String formatAmount(double amount) {
        return decimalFormat.format(amount);
    }

    // Проверка корректности суммы
    public static boolean isValidAmount(String amountStr) {
        if (amountStr == null || amountStr.trim().isEmpty()) {
            return false;
        }
        try {
            double amount = Double.parseDouble(amountStr);
            return amount > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Получение числового значения из строки
    public static double parseAmount(String amountStr) throws NumberFormatException {
        return Double.parseDouble(amountStr.trim());
    }

    // Расчет обратного курса (для отображения в обе стороны)
    public static double getReverseRate(double rate) {
        if (rate == 0) {
            return 0;
        }
        return 1.0 / rate;
    }
}