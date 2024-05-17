package com.example.randomnumbergenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText txtMin;
    EditText txtMax;
    Button btnGenerate;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtMin = (EditText) findViewById(R.id.minEditText);
        txtMax = (EditText) findViewById(R.id.maxEditText);
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        txtResult = (TextView) findViewById(R.id.textResult);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput(txtMin, txtMax) == true) {
                    int min;
                    int max;
                    min = Integer.parseInt(txtMin.getText().toString());
                    max = Integer.parseInt(txtMax.getText().toString());
                    int result = generateRandomNumber(min, max);
                    txtResult.setText(result + " ");
                } else {
                    txtResult.setText("Invalid!");
                }
            }
        });
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        //max - min de tinh range can duoc random tu 0 toi (max - min)
        //do nextInt(n) khong tinh so n nen phai +1 de tinh luon so do
        //+min de tinh random bat dau tu con so min
        return random.nextInt(max - min + 1) + min;
    }

    private boolean validateInput(EditText inputMin, EditText inputMax) {
        if (inputMin == null || inputMax == null){
            return false;
        }
        int min;
        int max;
        try {
            min = Integer.parseInt(inputMin.getText().toString());
            max = Integer.parseInt(inputMax.getText().toString());
        } catch (NumberFormatException e) {
            return false;
        }
        if (min < 0 || max < 0) {
            return false;
        }
        if (min >= max) {
            return false;
        }
        return true;
    }
}