package com.example.intentexplicitdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView txtString;
    TextView txtNumber;
    TextView txtArray;
    TextView txtObj;
    TextView txtBundle;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        txtString = (TextView) findViewById(R.id.textViewString);
        txtNumber = (TextView) findViewById(R.id.textViewNumber);
        txtArray = (TextView) findViewById(R.id.textViewArray);
        txtObj = (TextView) findViewById(R.id.textViewObj);
        txtBundle = (TextView) findViewById(R.id.textViewBundle);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        String stringResult = intent.getStringExtra("StringData");
        txtString.setText(stringResult);

        int numberResult = intent.getIntExtra("NumberData", 0);
        txtNumber.setText("" + numberResult);

        String[] array = intent.getStringArrayExtra("ArrayData");
        if (array != null) {
            StringBuilder arrayContent = new StringBuilder();
            for (String item : array) {
                arrayContent.append(item).append(" ");
            }
            txtArray.setText(arrayContent.toString().trim());
        }

        Student student = (Student) intent.getSerializableExtra("ObjData");
        if (student != null) {
            txtObj.setText(student.getLastName() + " " + student.getFirstName() + " " + student.getAge());
        }

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String bundleString = bundle.getString("string_key");
            int bundleNumber = bundle.getInt("number_key", 0);
            String[] bundleArray = bundle.getStringArray("array_key");
            Student bundleStudent = (Student) bundle.getSerializable("obj_key");

            StringBuilder bundleContent = new StringBuilder();
            if (bundleString != null) {
                bundleContent.append("String: ").append(bundleString).append("\n");
            }
            bundleContent.append("Number: ").append(bundleNumber).append("\n");
            if (bundleArray != null) {
                bundleContent.append("Array: ");
                for (String item : bundleArray) {
                    bundleContent.append(item).append(" ");
                }
                bundleContent.append("\n");
            }
            if (bundleStudent != null) {
                bundleContent.append("Student: ").append(bundleStudent.getLastName()).append(" ")
                        .append(bundleStudent.getFirstName()).append(" ").append(bundleStudent.getAge());
            }

            txtBundle.setText(bundleContent.toString().trim());
        }
    }
}