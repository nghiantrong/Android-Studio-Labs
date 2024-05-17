package com.example.calculator;

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

public class MainActivity extends AppCompatActivity {
    EditText txtNum1;
    EditText txtNum2;
    Button btnAdd;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtNum1 = (EditText) findViewById(R.id.editTextText);
        txtNum2 = (EditText) findViewById(R.id.editTextText2);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        txtResult = (TextView) findViewById(R.id.textView7);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers(txtNum1, txtNum2) == true) {
                    int num1;
                    int num2;
                    int result;
                    num1 = Integer.parseInt(txtNum1.getText().toString());
                    num2 = Integer.parseInt(txtNum2.getText().toString());
                    result = addNumbers(num1, num2);
                    txtResult.setText(result + " ");
                } else {
                    txtResult.setText("Invalid!!!");
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers(txtNum1, txtNum2) == true) {
                    int num1;
                    int num2;
                    int result;
                    num1 = Integer.parseInt(txtNum1.getText().toString());
                    num2 = Integer.parseInt(txtNum2.getText().toString());
                    result = minusNumbers(num1, num2);
                    txtResult.setText(result + " ");
                } else {
                    txtResult.setText("Invalid!!!");
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers(txtNum1, txtNum2) == true) {
                    int num1;
                    int num2;
                    int result;
                    num1 = Integer.parseInt(txtNum1.getText().toString());
                    num2 = Integer.parseInt(txtNum2.getText().toString());
                    result = multiplyNumbers(num1, num2);
                    txtResult.setText(result + " ");
                } else {
                    txtResult.setText("Invalid!!!");
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers(txtNum1, txtNum2) == true) {
                    double num1;
                    double num2;
                    double result;
                    num1 = Double.parseDouble(txtNum1.getText().toString());
                    num2 = Double.parseDouble(txtNum2.getText().toString());
                    result = divideNumbers(num1, num2);
                    if (Double.isInfinite(result)) {
                        txtResult.setText("Cannot divide by zero");
                    } else {
                        txtResult.setText(result + " ");
                    }
                } else {
                    txtResult.setText("Invalid!!!");
                }
            }
        });
    }

    private boolean validateNumbers(EditText txtNum1, EditText txtNum2) {
        if (txtNum1 == null || txtNum2 == null) {
            return false;
        }
        int num1;
        int num2;
        try {
            num1 = Integer.parseInt(txtNum1.getText().toString());
            num2 = Integer.parseInt(txtNum2.getText().toString());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private int addNumbers(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    private int minusNumbers(int num1, int num2) {
        int result = num1 - num2;
        return result;
    }

    private int multiplyNumbers(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    private double divideNumbers(double num1, double num2) {
        double result = num1 / num2;
        return result;
    }


}