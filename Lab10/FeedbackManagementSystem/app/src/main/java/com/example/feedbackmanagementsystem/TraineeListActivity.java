package com.example.feedbackmanagementsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.feedbackmanagementsystem.api.TraineeRepository;
import com.example.feedbackmanagementsystem.api.TraineeService;
import com.example.feedbackmanagementsystem.model.Trainee;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TraineeListActivity extends AppCompatActivity {

    private TraineeService traineeService;
    ListView lvTrainees;
    TraineeAdapter adapter;
    List<Trainee> traineeList;
    Button btnUpdate, btnReset, btnDelete;
    EditText etNameEdit, etEmailEdit, etPhoneEdit, etGenderEdit;
    long traineeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainee_list);

        lvTrainees = findViewById(R.id.lvTrainees);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        etEmailEdit = (EditText) findViewById(R.id.etEmailEdit);
        etGenderEdit = (EditText) findViewById(R.id.etGenderEdit);
        etNameEdit = (EditText) findViewById(R.id.etNameEdit);
        etPhoneEdit = (EditText) findViewById(R.id.etPhoneEdit);

        traineeList = new ArrayList<>();
        adapter = new TraineeAdapter(this, traineeList);
        lvTrainees.setAdapter(adapter);

        traineeService = TraineeRepository.getTraineeService();

        fetchTrainees();

        lvTrainees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Trainee selected = traineeList.get(position);
                etNameEdit.setText(selected.getName());
                etEmailEdit.setText(selected.getEmail());
                etGenderEdit.setText(selected.getGender());
                etPhoneEdit.setText(selected.getPhone());

                traineeId = selected.getId();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etNameEdit.getText().toString();
                String email = etEmailEdit.getText().toString();
                String phone = etPhoneEdit.getText().toString();
                String gender = etGenderEdit.getText().toString();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(TraineeListActivity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                    return;
                }

                Trainee trainee = new Trainee(name, email, phone, gender);
                Call<Trainee> call = traineeService.updateTrainees(traineeId, trainee);
                call.enqueue(new Callback<Trainee>() {
                    @Override
                    public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                        if (response.body() != null) {
                            Toast.makeText(TraineeListActivity.this, "Update successfully!",
                                    Toast.LENGTH_LONG).show();
                            fetchTrainees();
                            Reset();
                        }
                    }

                    @Override
                    public void onFailure(Call<Trainee> call, Throwable t) {
                        Toast.makeText(TraineeListActivity.this, "Failed to update trainee",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Trainee> call = traineeService.deleteTrainees(traineeId);
                call.enqueue(new Callback<Trainee>() {
                    @Override
                    public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                        if (response.body() != null) {
                            Toast.makeText(TraineeListActivity.this, "Delete successfully!",
                                    Toast.LENGTH_LONG).show();
                            fetchTrainees();
                            Reset();
                        }
                    }

                    @Override
                    public void onFailure(Call<Trainee> call, Throwable t) {
                        Toast.makeText(TraineeListActivity.this, "Failed to delete trainee",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();
            }
        });
    }

    private void Reset() {
        etNameEdit.setText("");
        etEmailEdit.setText("");
        etGenderEdit.setText("");
        etPhoneEdit.setText("");
        traineeId = -1;
    }

    private void fetchTrainees() {
        Call<Trainee[]> call = traineeService.getAllTrainees();
        call.enqueue(new Callback<Trainee[]>() {
            @Override
            public void onResponse(Call<Trainee[]> call, Response<Trainee[]> response) {
                Trainee[] trainees = response.body();
                if (trainees == null) {
                    return;
                }

                traineeList.clear();
                for (Trainee trainee : trainees) {
                    traineeList.add(trainee);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Trainee[]> call, Throwable t) {
                Toast.makeText(TraineeListActivity.this, "Failed to fetch trainees",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}