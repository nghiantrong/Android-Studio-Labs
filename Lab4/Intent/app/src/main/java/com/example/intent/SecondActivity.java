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

public class SecondActivity extends Activity {
    Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnSecond = (Button) findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA", "onCreate Second");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("BBB", "onStart Second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CCC", "onRestart Second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DDD", "onResume Second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("EEE", "onSPause Second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FFF", "onStop Second");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("GGG", "onDestroy Second");
    }
}