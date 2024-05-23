package com.example.customlistview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ImagePickerDialog extends Dialog {
    public static Integer[] getAllDrawableResourceIds(Context context) {
        Field[] drawablesFields = R.drawable.class.getDeclaredFields();
        List<Integer> drawableResourceIds = new ArrayList<>();

        for (Field field : drawablesFields) {
            try {
                int resourceId = field.getInt(null);
                drawableResourceIds.add(resourceId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return drawableResourceIds.toArray(new Integer[0]);
    }

    Integer[] allDrawableResourceIds = getAllDrawableResourceIds(getContext());
    private OnImageSelectedListener listener;

    public ImagePickerDialog(Context context, OnImageSelectedListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_image_picker);

        GridView gridView = findViewById(R.id.gridView);
        ImageAdapter adapter = new ImageAdapter(getContext(), allDrawableResourceIds);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    listener.onImageSelected(allDrawableResourceIds[position]);
                }
                dismiss();
            }
        });
    }

    public interface OnImageSelectedListener {
        void onImageSelected(int imageResId);
    }
}
