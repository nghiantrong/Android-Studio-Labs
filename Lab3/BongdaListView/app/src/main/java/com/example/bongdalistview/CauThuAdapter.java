package com.example.bongdalistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CauThuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CauThu> cauThuList;

    public CauThuAdapter(Context context, int layout, List<CauThu> cauThuList) {
        this.context = context;
        this.layout = layout;
        this.cauThuList = cauThuList;
    }

    @Override
    public int getCount() {
//        return 0;
        return cauThuList.size();
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

        TextView txtTen = (TextView) convertView.findViewById(R.id.textViewTen);
        TextView txtMota = (TextView) convertView.findViewById(R.id.textViewMota);
        ImageView imageHinh = (ImageView) convertView.findViewById(R.id.imageviewHinh);
        ImageView imageCo = (ImageView) convertView.findViewById(R.id.imageviewCo);

        CauThu cauThu = cauThuList.get(position);

        txtTen.setText(cauThu.getTen());
        txtMota.setText(cauThu.getMota());
        imageHinh.setImageResource(cauThu.getHinh());
        imageCo.setImageResource(cauThu.getCo());

        return convertView;
    }
}
