import java.util.Map;

public class ExchangeRateResponse {
    private String result;
    private String documentation;
    private String terms_of_use;
    private long time_last_update_unix;
    private String time_last_update_utc;
    private long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Конструктор по умолчанию
    public ExchangeRateResponse() {}

    // Геттеры
    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTermsOfUse() {
        return terms_of_use;
    }

    public long getTimeLastUpdateUnix() {
        return time_last_update_unix;
    }

    public String getTimeLastUpdateUtc() {
        return time_last_update_utc;
    }

    public long getTimeNextUpdateUnix() {
        return time_next_update_unix;
    }

    public String getTimeNextUpdateUtc() {
        return time_next_update_utc;
    }

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    // Сеттеры
    public void setResult(String result) {
        this.result = result;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public void setTermsOfUse(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public void setTimeLastUpdateUnix(long time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public void setTimeLastUpdateUtc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public void setTimeNextUpdateUnix(long time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    public void setTimeNextUpdateUtc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }

    public void setConversionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    // Вспомогательный метод для получения курса конкретной валюты
    public Double getRate(String currencyCode) {
        if (conversion_rates != null) {
            return conversion_rates.get(currencyCode);
        }
        return null;
    }

    // Проверка успешности ответа
    public boolean isSuccess() {
        return "success".equals(result);
    }
}