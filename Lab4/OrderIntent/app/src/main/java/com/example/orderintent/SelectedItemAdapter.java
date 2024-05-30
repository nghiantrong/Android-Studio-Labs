package com.example.orderintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SelectedItemAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SelectedItem> itemList;

    public SelectedItemAdapter(Context context, int layout, List<SelectedItem> itemList) {
        this.context = context;
        this.layout = layout;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
//        return 0;
        return itemList.size();
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

        TextView txtName = (TextView) convertView.findViewById(R.id.txtItemName);
        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtItemPrice);
        ImageView image = (ImageView) convertView.findViewById(R.id.imgItem);

        SelectedItem item = itemList.get(position);

        txtName.setText(item.getName());
        txtPrice.setText(item.getPrice()+"VND");
        image.setImageResource(item.getPicture());

        return convertView;
    }
}
