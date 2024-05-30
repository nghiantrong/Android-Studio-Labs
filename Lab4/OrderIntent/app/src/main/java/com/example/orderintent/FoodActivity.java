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

public class FoodActivity extends AppCompatActivity {
    ListView lvFood;
    ArrayList<SelectedItem> arrayFood;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food);
        Anhxa();
        adapter = new FoodAdapter(this, R.layout.activity_food_layout, arrayFood);
        lvFood.setAdapter(adapter);

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectedItem selectedFood = arrayFood.get(position);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("itemName", selectedFood.getName());
                resultIntent.putExtra("itemPrice", selectedFood.getPrice());
                resultIntent.putExtra("itemImage", selectedFood.getPicture());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }

    private void Anhxa() {
        lvFood = (ListView) findViewById(R.id.lvFood);
        arrayFood = new ArrayList<>();
        arrayFood.add(new SelectedItem("Phở Hà Nội", 45000, R.drawable.pho));
        arrayFood.add(new SelectedItem("Bún Bò Huế", 35000, R.drawable.bunbo));
        arrayFood.add(new SelectedItem("Mì Quảng", 30000, R.drawable.miquang));
        arrayFood.add(new SelectedItem("Hủ Tíu Sài Gòn", 35000, R.drawable.hutieu));
        arrayFood.add(new SelectedItem("Bánh Canh Ghẹ", 50000, R.drawable.banhcanhghe));
        arrayFood.add(new SelectedItem("Bún Chả Hà Nội", 40000, R.drawable.bunchahanoi));
        arrayFood.add(new SelectedItem("Mì Vịt Tiềm", 65000, R.drawable.mivittiem));
    }
}