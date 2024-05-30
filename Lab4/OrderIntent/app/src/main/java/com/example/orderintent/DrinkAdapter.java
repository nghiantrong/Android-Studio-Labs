package com.example.orderintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DrinkAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SelectedItem> drinkList;

    public DrinkAdapter(Context context, int layout, List<SelectedItem> drinkList) {
        this.context = context;
        this.layout = layout;
        this.drinkList = drinkList;
    }

    @Override
    public int getCount() {
//        return 0;
        return drinkList.size();
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

        TextView txtDrinkName = (TextView) convertView.findViewById(R.id.tvDrinkName);
        TextView txtDrinkPrice = (TextView) convertView.findViewById(R.id.tvDrinkPrice);
        ImageView imageDrink = (ImageView) convertView.findViewById(R.id.ivDrink);

        SelectedItem drink = drinkList.get(position);

        txtDrinkName.setText(drink.getName());
        txtDrinkPrice.setText(drink.getPrice()+"VND");
        imageDrink.setImageResource(drink.getPicture());

        return convertView;
    }
}
