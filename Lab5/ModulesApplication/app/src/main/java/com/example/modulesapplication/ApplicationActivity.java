package com.example.modulesapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApplicationActivity extends AppCompatActivity implements ApplicationAdapter.OnItemClickListener, ImagePickerDialog.OnImageSelectedListener {
    private ArrayList<Application> applicationList;
    ImageView ivImage;
    ImageView ivIcon;
    EditText edtTitle;
    EditText edtDescription;
    Button btnAdd,btnDelete, btnEdit;

    int selectedImageResId1 = -1;
    int selectedImageResId2 = -1;
    int vitri = -1;
    ImageView currentImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        RecyclerView rvApplication = findViewById(R.id.rvApplication);
        ivImage = (ImageView) findViewById(R.id.ivImageEdit);
        ivIcon = (ImageView) findViewById(R.id.ivIconEdit);
        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtDescription = (EditText) findViewById(R.id.edtDescription);
        btnAdd = (Button) findViewById(R.id.btnThem);
        btnDelete = (Button) findViewById(R.id.btnXoa);
        btnEdit = (Button) findViewById(R.id.btnCapnhat);

        applicationList = new ArrayList<>();
        applicationList.add(new Application(R.drawable.listview, "ListView trong Android",
                "ListView trong Android là một thành phần dùng trong nhiều mục item", R.drawable.android));
        applicationList.add(new Application(R.drawable.xulisukien, "Xử lí trong IOS",
                "Xử lí trong IOS. Sau khi bạn biết được thiết kế của cái app của mình", R.drawable.ios));
        applicationList.add(new Application(R.drawable.docker, "Docker trong lập trình",
                "Docker trong lập trình. Khi docker làm đầy ổ cứng C thì hãy dọn các images", R.drawable.dockericon));
        applicationList.add(new Application(R.drawable.springcode, "Spring boot trong lập trình",
                "Spring boot trong lập trình. Spring boot là một framework giúp mình code dễ dàng hơn", R.drawable.spring));
        applicationList.add(new Application(R.drawable.razorpage, "Razor page trong .NET",
                "Razor page trong .NET. Razor page hiện tại không được ưa chuộng lắm do mức độ phiền phức", R.drawable.dotnet));
        applicationList.add(new Application(R.drawable.swiftcode, "Swift trong lập trình",
                "Swift trong lập trình. Nêu muốn code cho IOS, hãy dùng swift thay vì dùng android studio", R.drawable.swift));
        applicationList.add(new Application(R.drawable.intent, "Intent trong Android",
                "Intent trong ssAndroid. Được dùng để chuyển các activity, có thể dùng để chuyển data cho nhau", R.drawable.android));

        ApplicationAdapter adapter = new ApplicationAdapter(applicationList, this);

        rvApplication.setAdapter(adapter);

        rvApplication.setLayoutManager(new LinearLayoutManager(this));

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = ivImage;
                ImagePickerDialog dialog = new ImagePickerDialog(ApplicationActivity.this, ApplicationActivity.this);
                dialog.show();
            }
        });

        ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageView = ivIcon;
                ImagePickerDialog dialog = new ImagePickerDialog(ApplicationActivity.this, ApplicationActivity.this);
                dialog.show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String description = edtDescription.getText().toString();

                if (title.isEmpty() || description.isEmpty() || selectedImageResId1 == -1 || selectedImageResId2 == -1) {
                    return;
                }

                Application application = new Application(selectedImageResId1, title, description, selectedImageResId2);
                applicationList.add(application);
                adapter.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applicationList.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String description = edtDescription.getText().toString();

                if (!title.isEmpty() && !description.isEmpty() && selectedImageResId1 != -1 && selectedImageResId2 != -1 ) {
                    Application application = applicationList.get(vitri);
                    application.setTitle(title);
                    application.setDescription(description);
                    application.setImage(selectedImageResId1);
                    application.setIcon(selectedImageResId2);

                    applicationList.set(vitri, application);
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle empty fields or no image selected
                }
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        edtTitle.setText(applicationList.get(position).getTitle());
        edtDescription.setText(applicationList.get(position).getDescription());
        ivImage.setImageResource(applicationList.get(position).getImage());
        ivIcon.setImageResource(applicationList.get(position).getIcon());
        vitri = position;
        Toast.makeText(this, "Item: " + applicationList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onImageSelected(int imageResId) {
        if (currentImageView != null) {
            if (currentImageView == ivImage) {
                selectedImageResId1 = imageResId;
                ivImage.setImageResource(imageResId);
            } else if (currentImageView == ivIcon) {
                selectedImageResId2 = imageResId;
                ivIcon.setImageResource(imageResId);
            }
        }
    }
}