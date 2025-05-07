package com.example.gridviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    ArrayList<ITEMActivity> listItem;

    public GridAdapter(Context context, int layout, ArrayList<ITEMActivity> listItem) {
        this.context = context;
        this.layout = layout;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return 0;
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
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(layout,null);

        ImageView imageView=convertView.findViewById(R.id.imageView2);

        TextView textView=convertView.findViewById(R.id.textView);
        TextView textView1=convertView.findViewById(R.id.textView2);
        TextView textView2=convertView.findViewById(R.id.textView3);

        ITEMActivity Item=listItem.get(position);
        imageView.setImageResource(Item.getHinh());
        textView.setText(Item.getTen()[0]);
        textView1.setText(Item.getTen()[1]);
        textView2.setText(Item.getTen()[2]);


        return convertView;
    }
}
