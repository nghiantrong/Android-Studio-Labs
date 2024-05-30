package com.example.orderintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnFood;
    Button btnDrink;
    ListView lvSelectedItems;
    ArrayList<SelectedItem> selectedItems;
    SelectedItemAdapter adapter;

    private static final int REQUEST_CODE_FOOD = 1;
    private static final int REQUEST_CODE_DRINK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnFood = (Button) findViewById(R.id.buttonFood);
        btnDrink = (Button) findViewById(R.id.buttonDrink);
        lvSelectedItems = (ListView) findViewById(R.id.lvSelectedItems);
        selectedItems = new ArrayList<>();
        adapter = new SelectedItemAdapter(this, R.layout.selected_item_layout, selectedItems);
        lvSelectedItems.setAdapter(adapter);

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(intent, REQUEST_CODE_FOOD);
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
                startActivityForResult(intent, REQUEST_CODE_DRINK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == REQUEST_CODE_FOOD || requestCode == REQUEST_CODE_DRINK) && resultCode == RESULT_OK) {
            if (data != null) {
                String itemName = data.getStringExtra("itemName");
                int itemPrice = data.getIntExtra("itemPrice", 0);
                int itemImage = data.getIntExtra("itemImage", 0);

                SelectedItem selectedItem = new SelectedItem(itemName, itemPrice, itemImage);
                selectedItems.add(selectedItem);
                adapter.notifyDataSetChanged();
            }
        }
    }

}