package com.example.orderintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SelectedItem> foodList;

    public FoodAdapter(Context context, int layout, List<SelectedItem> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }
    @Override
    public int getCount() {
//        return 0;
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtFoodName = (TextView) convertView.findViewById(R.id.tvFoodName);
        TextView txtFoodPrice = (TextView) convertView.findViewById(R.id.tvFoodPrice);
        ImageView imageFood = (ImageView) convertView.findViewById(R.id.ivFood);

        SelectedItem food = foodList.get(position);

        txtFoodName.setText(food.getName());
        txtFoodPrice.setText(food.getPrice()+"VND");
        imageFood.setImageResource(food.getPicture());

        return convertView;
    }
}
