package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputValue;
    Spinner conversionTypeSpinner;
    Button convertButton;
    TextView resultText;

    String[] conversionOptions = {
            "Centimeters to Meters",
            "Meters to Centimeters",
            "Grams to Kilograms",
            "Kilograms to Grams"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        conversionTypeSpinner = findViewById(R.id.conversionTypeSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, conversionOptions);
        conversionTypeSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertValue();
            }
        });
    }

    private void convertValue() {
        String input = inputValue.getText().toString();
        if (input.isEmpty()) {
            resultText.setText("Please enter a value.");
            return;
        }

        double value = Double.parseDouble(input);
        int selectedPosition = conversionTypeSpinner.getSelectedItemPosition();
        double result = 0;
        String unit = "";

        switch (selectedPosition) {
            case 0: // cm to m
                result = value / 100.0;
                unit = " meters";
                break;
            case 1: // m to cm
                result = value * 100.0;
                unit = " centimeters";
                break;
            case 2: // g to kg
                result = value / 1000.0;
                unit = " kilograms";
                break;
            case 3: // kg to g
                result = value * 1000.0;
                unit = " grams";
                break;
        }

        resultText.setText("Result: " + result + unit);
    }
}
