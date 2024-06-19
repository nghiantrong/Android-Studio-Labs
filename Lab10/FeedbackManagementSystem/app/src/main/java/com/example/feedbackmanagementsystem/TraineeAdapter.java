package com.example.feedbackmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.feedbackmanagementsystem.model.Trainee;

import java.util.List;

public class TraineeAdapter extends ArrayAdapter<Trainee> {

    public TraineeAdapter(Context context, List<Trainee> trainees) {
        super(context, 0, trainees);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Trainee trainee = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_trainee, parent, false);
        }

        // Lookup view for data population
        TextView tvTraineeName = convertView.findViewById(R.id.tvTraineeName);
        TextView tvTraineeEmail = convertView.findViewById(R.id.tvTraineeEmail);
        TextView tvTraineePhone = convertView.findViewById(R.id.tvTraineePhone);
        TextView tvTraineeGender = convertView.findViewById(R.id.tvTraineeGender);

        // Populate the data into the template view using the data object
        tvTraineeName.setText("Name: " + trainee.getName());
        tvTraineeEmail.setText("Email: " + trainee.getEmail());
        tvTraineePhone.setText("Phone: " + trainee.getPhone());
        tvTraineeGender.setText("Gender: " + trainee.getGender());

        // Return the completed view to render on screen
        return convertView;
    }
}
