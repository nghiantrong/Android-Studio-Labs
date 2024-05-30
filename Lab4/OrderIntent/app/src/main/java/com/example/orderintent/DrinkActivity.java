package com.example.orderintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {
    ListView lvDrink;
    ArrayList<SelectedItem> arrayDrink;
    DrinkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drink);
        Anhxa();
        adapter = new DrinkAdapter(this, R.layout.activity_drink_layout, arrayDrink);
        lvDrink.setAdapter(adapter);

        lvDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectedItem selectedFood = arrayDrink.get(position);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("itemName", selectedFood.getName());
                resultIntent.putExtra("itemPrice", selectedFood.getPrice());
                resultIntent.putExtra("itemImage", selectedFood.getPicture());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void Anhxa(){
        lvDrink = (ListView) findViewById(R.id.lvDrink);
        arrayDrink = new ArrayList<>();
        arrayDrink.add(new SelectedItem("Pepsi", 12000, R.drawable.pepsi));
        arrayDrink.add(new SelectedItem("Heineken", 20000, R.drawable.heineken));
        arrayDrink.add(new SelectedItem("Tiger", 22000, R.drawable.tigger));
        arrayDrink.add(new SelectedItem("Sài Gòn Đỏ", 18000, R.drawable.biasaigon));
        arrayDrink.add(new SelectedItem("Sprite", 11000, R.drawable.sprite));
        arrayDrink.add(new SelectedItem("Soju", 50000, R.drawable.soju));
        arrayDrink.add(new SelectedItem("Nước Ép", 15000, R.drawable.nuocep));
    }
}