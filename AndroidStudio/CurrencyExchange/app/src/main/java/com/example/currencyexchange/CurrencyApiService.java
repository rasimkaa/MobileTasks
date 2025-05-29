import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrencyApiService {

    // Получение курсов валют относительно базовой валюты
    @GET("latest/{base}")
    Call<ExchangeRateResponse> getExchangeRates(@Path("base") String baseCurrency);

    // Получение курсов USD (самый популярный запрос)
    @GET("latest/USD")
    Call<ExchangeRateResponse> getUSDRates();

    // Получение курсов EUR
    @GET("latest/EUR")
    Call<ExchangeRateResponse> getEURRates();

    // Получение курсов RUB
    @GET("latest/RUB")
    Call<ExchangeRateResponse> getRUBRates();
}