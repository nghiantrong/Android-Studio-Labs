package com.example.intentexplicitdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnString;
    Button btnNumber;
    Button btnArray;
    Button btnObj;
    Button btnBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnString = (Button) findViewById(R.id.btnString);
        btnNumber = (Button) findViewById(R.id.btnNumber);
        btnArray = (Button) findViewById(R.id.btnArray);
        btnObj = (Button) findViewById(R.id.btnObj);
        btnBundle = (Button) findViewById(R.id.btnBundle);


        btnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //Truyen chuoi
                intent.putExtra("StringData", "Truyền chuỗi");
                startActivity(intent);
            }
        });

        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //Truyen so
                intent.putExtra("NumberData", 69);
                startActivity(intent);
            }
        });

        btnArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String[] array = {"Android", "IOS", "PHP", "Unity"};
                intent.putExtra("ArrayData", array);
                startActivity(intent);
            }
        });

        btnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Student student = new Student("Nghia", "Trong", 30);
                intent.putExtra("ObjData", student);
                startActivity(intent);
            }
        });

        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String string = "Truyền chuỗi";
                int number = 69;
                String[] array = {"Android", "IOS", "PHP", "Unity"};
                Student student = new Student("Nghia", "Trong", 30);

                Bundle bundle = new Bundle();
                bundle.putString("string_key", string);
                bundle.putInt("number_key", number);
                bundle.putStringArray("array_key", array);
                bundle.putSerializable("obj_key", student);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}