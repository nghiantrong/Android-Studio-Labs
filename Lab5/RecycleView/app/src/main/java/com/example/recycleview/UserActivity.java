package com.example.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView rvUser = findViewById(R.id.rvUser);

        userList = new ArrayList<>();
        userList.add(new User("NguyenTT", "Tran Thanh Nguyen", "Nguyentt@fpt.edu.vn"));
        userList.add(new User("AnTV", "Tran Van An", "antv@gmail.com"));
        userList.add(new User("BangTT", "Tran Thanh Bang", "bangtt@gmail.com"));
        userList.add(new User("KhangTT", "Tran Thanh Khang", "khangtt@gmail.com"));
        userList.add(new User("BaoNT", "Nguyen Thanh Bao", "baont@gmail.com"));
        userList.add(new User("HungVH", "Vo Huy Hung", "hungvh@gmail.com"));
        userList.add(new User("TuVH", "Vo Huy Tu", "hungvh@gmail.com"));
        userList.add(new User("HuyVH", "Vo Huy Huy", "hungvh@gmail.com"));
        userList.add(new User("NghiaVH", "Vo Huy Nghia", "hungvh@gmail.com"));
        userList.add(new User("HaVH", "Vo Huy Ha", "hungvh@gmail.com"));
        userList.add(new User("LamVH", "Vo Huy Lam", "hungvh@gmail.com"));

        UserAdapter adapter = new UserAdapter(userList);

        rvUser.setAdapter(adapter);

        rvUser.setLayoutManager(new LinearLayoutManager(this));
    }
}