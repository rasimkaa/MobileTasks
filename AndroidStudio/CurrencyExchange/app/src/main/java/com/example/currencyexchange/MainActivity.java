import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // UI элементы
    private EditText etAmount;
    private Spinner spFromCurrency;
    private Spinner spToCurrency;
    private Button btnConvert;
    private TextView tvResult;
    private ProgressBar progressBar;

    // API сервис
    private CurrencyApiService apiService;

    // Коды валют для API запросов
    private String[] currencyCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов интерфейса
        initViews();

        // Настройка Retrofit для работы с API
        setupRetrofit();

        // Настройка выпадающих списков валют
        setupSpinners();

        // Настройка кнопки конвертации
        setupConvertButton();
    }

    /**
     * Инициализация UI элементов
     */
    private void initViews() {
        etAmount = findViewById(R.id.etAmount);
        spFromCurrency = findViewById(R.id.spFromCurrency);
        spToCurrency = findViewById(R.id.spToCurrency);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);
        progressBar = findViewById(R.id.progressBar);
    }

    /**
     * Настройка Retrofit для работы с API
     */
    private void setupRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.exchangerate-api.com/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(CurrencyApiService.class);
    }

    /**
     * Настройка выпадающих списков валют
     */
    private void setupSpinners() {
        // Получаем массивы валют из ресурсов
        String[] currencies = getResources().getStringArray(R.array.currencies);
        currencyCodes = getResources().getStringArray(R.array.currency_codes);

        // Создаем адаптер для списков
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                currencies
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Устанавливаем адаптер для обоих списков
        spFromCurrency.setAdapter(adapter);
        spToCurrency.setAdapter(adapter);

        // Устанавливаем значения по умолчанию (USD -> EUR)
        spFromCurrency.setSelection(0); // USD
        spToCurrency.setSelection(1);   // EUR
    }

    /**
     * Настройка кнопки конвертации
     */
    private void setupConvertButton() {
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    /**
     * Выполнение конвертации валют
     */
    private void performConversion() {
        // Получаем введенную сумму
        String amountStr = etAmount.getText().toString().trim();

        // Проверяем корректность суммы
        if (!CurrencyConverter.isValidAmount(amountStr)) {
            showError(getString(R.string.error_empty_amount));
            return;
        }

        try {
            // Парсим сумму
            double amount = CurrencyConverter.parseAmount(amountStr);

            // Получаем выбранные валюты
            String fromCurrency = currencyCodes[spFromCurrency.getSelectedItemPosition()];
            String toCurrency = currencyCodes[spToCurrency.getSelectedItemPosition()];

            // Если валюты одинаковые, показываем ту же сумму
            if (fromCurrency.equals(toCurrency)) {
                String result = String.format("%.2f %s = %.2f %s",
                        amount, fromCurrency, amount, toCurrency);
                showResult(result);
                return;
            }

            // Выполняем API запрос
            getCurrencyRates(fromCurrency, toCurrency, amount);

        } catch (NumberFormatException e) {
            showError(getString(R.string.error_empty_amount));
        }
    }

    /**
     * Получение курсов валют через API
     */
    private void getCurrencyRates(String fromCurrency, String toCurrency, double amount) {
        // Показываем индикатор загрузки
        showLoading(true);

        // Выполняем запрос к API
        Call<ExchangeRateResponse> call = apiService.getExchangeRates(fromCurrency);

        call.enqueue(new Callback<ExchangeRateResponse>() {
            @Override
            public void onResponse(Call<ExchangeRateResponse> call, Response<ExchangeRateResponse> response) {
                // Скрываем индикатор загрузки
                showLoading(false);

                if (response.isSuccessful() && response.body() != null) {
                    ExchangeRateResponse rateResponse = response.body();

                    if (rateResponse.isSuccess()) {
                        // Получаем курс целевой валюты
                        Double rate = rateResponse.getRate(toCurrency);

                        if (rate != null) {
                            // Выполняем конвертацию
                            double convertedAmount = CurrencyConverter.convert(amount, rate);

                            // Формируем и показываем результат
                            String result = String.format("%.2f %s = %.2f %s",
                                    amount, fromCurrency, convertedAmount, toCurrency);
                            showResult(result);

                            // Дополнительная информация о курсе
                            String rateInfo = String.format("Курс: 1 %s = %.4f %s",
                                    fromCurrency, rate, toCurrency);
                            Toast.makeText(MainActivity.this, rateInfo, Toast.LENGTH_SHORT).show();
                        } else {
                            showError("Валюта " + toCurrency + " не найдена");
                        }
                    } else {
                        showError(getString(R.string.error_conversion));
                    }
                } else {
                    showError(getString(R.string.error_network));
                }
            }

            @Override
            public void onFailure(Call<ExchangeRateResponse> call, Throwable t) {
                // Скрываем индикатор загрузки
                showLoading(false);

                // Показываем ошибку сети
                showError(getString(R.string.error_network) + ": " + t.getMessage());
            }
        });
    }

    /**
     * Показать результат конвертации
     */
    private void showResult(String result) {
        tvResult.setText(result);
        tvResult.setVisibility(View.VISIBLE);
    }

    /**
     * Показать ошибку
     */
    private void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        tvResult.setVisibility(View.GONE);
    }

    /**
     * Показать/скрыть индикатор загрузки
     */
    private void showLoading(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            btnConvert.setEnabled(false);
            btnConvert.setText("Загрузка...");
        } else {
            progressBar.setVisibility(View.GONE);
            btnConvert.setEnabled(true);
            btnConvert.setText(getString(R.string.convert));
        }
    }
}