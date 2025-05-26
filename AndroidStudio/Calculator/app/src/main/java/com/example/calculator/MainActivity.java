package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDisplay;
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isNewOperation = true;
    private boolean hasResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация дисплея
        tvDisplay = findViewById(R.id.tvDisplay);

        // Инициализация кнопок цифр
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        // Инициализация кнопок операций
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSubtract).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnPercent).setOnClickListener(this);

        // Инициализация специальных кнопок
        findViewById(R.id.btnEquals).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "C":
                clear();
                break;
            case "⌫":
                delete();
                break;
            case "=":
                calculate();
                break;
            case "+":
            case "-":
            case "×":
            case "÷":
            case "%":
                setOperator(buttonText);
                break;
            case ".":
                addDecimalPoint();
                break;
            default:
                // Цифры 0-9
                addNumber(buttonText);
                break;
        }
    }

    private void addNumber(String number) {
        if (hasResult) {
            clear();
            hasResult = false;
        }

        if (isNewOperation) {
            currentInput = number;
            isNewOperation = false;
        } else {
            if (currentInput.equals("0")) {
                currentInput = number;
            } else {
                currentInput += number;
            }
        }
        updateDisplay();
    }

    private void addDecimalPoint() {
        if (hasResult) {
            clear();
            hasResult = false;
        }

        if (isNewOperation) {
            currentInput = "0.";
            isNewOperation = false;
        } else if (!currentInput.contains(".")) {
            currentInput += ".";
        }
        updateDisplay();
    }

    private void setOperator(String op) {
        if (!currentInput.isEmpty() && !isNewOperation) {
            if (!operator.isEmpty()) {
                calculate();
            } else {
                firstNumber = Double.parseDouble(currentInput);
            }
        }

        operator = op;
        isNewOperation = true;
        hasResult = false;
    }

    private void calculate() {
        if (operator.isEmpty() || currentInput.isEmpty() || isNewOperation) {
            return;
        }

        double secondNumber = Double.parseDouble(currentInput);
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "×":
                result = firstNumber * secondNumber;
                break;
            case "÷":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    tvDisplay.setText("Ошибка");
                    clear();
                    return;
                }
                break;
            case "%":
                result = (firstNumber * secondNumber) / 100;
                break;
        }

        // Форматирование результата
        if (result == (long) result) {
            currentInput = String.valueOf((long) result);
        } else {
            currentInput = String.valueOf(result);
        }

        firstNumber = result;
        operator = "";
        isNewOperation = true;
        hasResult = true;
        updateDisplay();
    }

    private void clear() {
        currentInput = "";
        operator = "";
        firstNumber = 0;
        isNewOperation = true;
        hasResult = false;
        tvDisplay.setText("0");
    }

    private void delete() {
        if (!currentInput.isEmpty() && !isNewOperation) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            if (currentInput.isEmpty()) {
                currentInput = "0";
                isNewOperation = true;
            }
            updateDisplay();
        }
    }

    private void updateDisplay() {
        if (currentInput.isEmpty()) {
            tvDisplay.setText("0");
        } else {
            // Ограничиваем количество символов на дисплее
            String displayText = currentInput;
            if (displayText.length() > 12) {
                displayText = displayText.substring(0, 12);
            }
            tvDisplay.setText(displayText);
        }
    }
}