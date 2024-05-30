package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain = (Button) findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Log.d("AAA", "onCreate Main");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("BBB", "onStart Main");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CCC", "onRestart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DDD", "onResume Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("EEE", "onSPause Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FFF", "onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("GGG", "onDestroy Main");
    }
}