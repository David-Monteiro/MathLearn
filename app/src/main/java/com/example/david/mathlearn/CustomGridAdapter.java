package com.example.david.mathlearn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class CustomGridAdapter extends BaseAdapter {

    Context ctx;
    Integer [] items;

    CustomGridAdapter(Context c0, Integer [] i0){
        ctx = c0;
        items = i0;

    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(ctx);
            imageView.setPadding(8,8,8,8);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
        }
        else{
            imageView =(ImageView)convertView;
        }
        imageView.setImageResource(items[position]);

        return imageView;

    }
}
