package com.example.customlistview;

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
    ListView lvtraicay;
    ArrayList<TraiCay> arrayTraicay;
    TraiCayAdapter adapter;
    EditText edtMota;
    EditText edtTraiCay;
    ImageView ivHinh;
    Button btnThem;
    Button btnCapnhat;
    Button btnXoa;

    int selectedImageResId = -1;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraicay);
        lvtraicay.setAdapter(adapter);

        lvtraicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TraiCay selectedItem = arrayTraicay.get(position);
                edtTraiCay.setText(selectedItem.getTen());
                edtMota.setText(selectedItem.getMota());
                ivHinh.setImageResource(selectedItem.getHinh());
                selectedImageResId = selectedItem.getHinh();
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
                arrayTraicay.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });

        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenTraiCay = edtTraiCay.getText().toString();
                String moTa = edtMota.getText().toString();

                if (!tenTraiCay.isEmpty() && !moTa.isEmpty() && selectedImageResId != -1) {
                    TraiCay updatedTraiCay = arrayTraicay.get(vitri);
                    updatedTraiCay.setTen(tenTraiCay);
                    updatedTraiCay.setMota(moTa);
                    updatedTraiCay.setHinh(selectedImageResId);

                    arrayTraicay.set(vitri, updatedTraiCay);
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle empty fields or no image selected
                }
            }
        });

        ivHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePickerDialog dialog = new ImagePickerDialog(MainActivity.this, MainActivity.this);
                dialog.show();
            }
        });
    }

    private void AnhXa() {
        lvtraicay = (ListView) findViewById(R.id.lvTraicay);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnCapnhat = (Button) findViewById(R.id.btnCapnhat);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        edtMota = (EditText) findViewById(R.id.edtMota);
        edtTraiCay = (EditText) findViewById(R.id.edtTraicay);
        ivHinh = (ImageView) findViewById(R.id.ivHinh);
        arrayTraicay = new ArrayList<>();
        arrayTraicay.add(new TraiCay("apple", "apple...some description goes here...", R.drawable.applewithleaf));
        arrayTraicay.add(new TraiCay("banana", "banana...some description goes here...", R.drawable.banana));
        arrayTraicay.add(new TraiCay("blueberry", "blueberry...some description goes here...", R.drawable.blueberry));
        arrayTraicay.add(new TraiCay("corn", "corn...some description goes here...", R.drawable.corn));
        arrayTraicay.add(new TraiCay("grapes", "grapes...some description goes here...", R.drawable.grapes));
    }

    @Override
    public void onImageSelected(int imageResId) {
        selectedImageResId = imageResId;
        ivHinh.setImageResource(imageResId);
    }

    private void addNewItem() {
        String tenTraiCay = edtTraiCay.getText().toString();
        String moTa = edtMota.getText().toString();

        if (tenTraiCay.isEmpty() || moTa.isEmpty() || selectedImageResId == -1) {
            return;
        }

        TraiCay newTraiCay = new TraiCay(tenTraiCay, moTa, selectedImageResId);
        arrayTraicay.add(newTraiCay);
        adapter.notifyDataSetChanged();
    }

    private void resetFields() {
        edtTraiCay.setText("");
        edtMota.setText("");
        ivHinh.setImageResource(0);
        selectedImageResId = -1;
    }
}