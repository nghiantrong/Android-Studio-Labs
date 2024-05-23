package com.example.bongdalistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ImagePickerDialog.OnImageSelectedListener {
    ListView lvcauthu;
    ArrayList<CauThu> arrayCauthu;
    CauThuAdapter adapter;
    EditText edtMota;
    EditText edtTen;
    ImageView ivHinh;
    ImageView ivCo;
    Button btnThem;
    Button btnCapnhat;
    Button btnXoa;

    int selectedImageResId1 = -1;
    int selectedImageResId2 = -1;
    int vitri = -1;
    ImageView currentImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new CauThuAdapter(this, R.layout.dong_cau_thu, arrayCauthu);
        lvcauthu.setAdapter(adapter);

        lvcauthu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CauThu selectedItem = arrayCauthu.get(position);
                edtTen.setText(selectedItem.getTen());
                edtMota.setText(selectedItem.getMota());
                ivHinh.setImageResource(selectedItem.getHinh());
                ivCo.setImageResource(selectedItem.getCo());
                selectedImageResId1 = selectedItem.getHinh();
                selectedImageResId2 = selectedItem.getCo();
                vitri = position;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewItem();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCauthu.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });

        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenCauThu = edtTen.getText().toString();
                String moTa = edtMota.getText().toString();

                if (!tenCauThu.isEmpty() && !moTa.isEmpty() && selectedImageResId1 != -1 && selectedImageResId2 != -1 ) {
                    CauThu updatedCauThu = arrayCauthu.get(vitri);
                    updatedCauThu.setTen(tenCauThu);
                    updatedCauThu.setMota(moTa);
                    updatedCauThu.setHinh(selectedImageResId1);
                    updatedCauThu.setCo(selectedImageResId2);

                    arrayCauthu.set(vitri, updatedCauThu);
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle empty fields or no image selected
                }
            }
        });

        ivHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = ivHinh;
                ImagePickerDialog dialog = new ImagePickerDialog(MainActivity.this, MainActivity.this);
                dialog.show();
            }
        });

        ivCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = ivCo;
                ImagePickerDialog dialog = new ImagePickerDialog(MainActivity.this, MainActivity.this);
                dialog.show();
            }
        });
    }

    private void AnhXa() {
        lvcauthu = (ListView) findViewById(R.id.lvBongda);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnCapnhat = (Button) findViewById(R.id.btnCapnhat);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        edtMota = (EditText) findViewById(R.id.edtMota);
        edtTen = (EditText) findViewById(R.id.edtTen);
        ivHinh = (ImageView) findViewById(R.id.ivHinh);
        ivCo = (ImageView) findViewById(R.id.ivCo);
        arrayCauthu = new ArrayList<>();
        arrayCauthu.add(new CauThu("Pele", "October 23, 1940 (age 72)", R.drawable.pele, R.drawable.brazil));
        arrayCauthu.add(new CauThu("Diego Maradona", "October 30, 1960 (age 52)", R.drawable.maradona, R.drawable.argentina));
        arrayCauthu.add(new CauThu("Johan Cruyff", "April 25, 1947 (age 65)", R.drawable.johan, R.drawable.netherlands));
        arrayCauthu.add(new CauThu("Franz Beckenbauer", "September 11, 1945 (age 67)", R.drawable.franz, R.drawable.germany));
        arrayCauthu.add(new CauThu("Michel Plantini", "June 21, 1955 (age 57)", R.drawable.michel, R.drawable.france));
        arrayCauthu.add(new CauThu("Ronaldo De Lima", "September 22, 1976 (age 36)", R.drawable.ronaldo, R.drawable.brazil));
    }

    @Override
    public void onImageSelected(int imageResId) {
        if (currentImageView != null) {
            if (currentImageView == ivHinh) {
                selectedImageResId1 = imageResId;
                ivHinh.setImageResource(imageResId);
            } else if (currentImageView == ivCo) {
                selectedImageResId2 = imageResId;
                ivCo.setImageResource(imageResId);
            }
        }
    }

    private void addNewItem() {
        String tenCauThu = edtTen.getText().toString();
        String moTa = edtMota.getText().toString();

        if (tenCauThu.isEmpty() || moTa.isEmpty() || selectedImageResId1 == -1 || selectedImageResId2 == -1) {
            return;
        }

        CauThu newCauThu = new CauThu(tenCauThu, moTa, selectedImageResId1, selectedImageResId2);
        arrayCauthu.add(newCauThu);
        adapter.notifyDataSetChanged();
    }

    private void resetFields() {
        edtTen.setText("");
        edtMota.setText("");
        ivHinh.setImageResource(0);
        ivCo.setImageResource(0);
        selectedImageResId1 = -1;
        selectedImageResId2 = -1;
    }
}