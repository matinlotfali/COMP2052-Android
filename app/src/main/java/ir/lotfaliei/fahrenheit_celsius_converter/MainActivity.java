package ir.lotfaliei.fahrenheit_celsius_converter;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner = findViewById(R.id.unit);
                TextView inputText = findViewById(R.id.inputText);
                TextView resultText = findViewById(R.id.resultText);
                Resources res = getResources();
                String c = res.getString(R.string.c);
                float input = Float.parseFloat(inputText.getText().toString());
                String result;

                if(spinner.getSelectedItem().equals(c)) {
                    float output = input * 1.8f + 32;
                    result = res.getString(R.string.result, output, res.getString(R.string.f));
                }
                else {
                    float output = (input - 32) / 1.8f;
                    result = res.getString(R.string.result, output, c);
                }

                resultText.setText(result);
            }
        });
    }
}
