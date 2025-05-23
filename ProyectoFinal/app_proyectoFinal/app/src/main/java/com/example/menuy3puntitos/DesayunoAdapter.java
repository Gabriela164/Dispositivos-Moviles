package com.example.menuy3puntitos;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import java.util.List;

public class DesayunoAdapter extends BaseAdapter {
    private final Context context;
    private final List<ItemDesayuno> items;

    private final FragmentManager fragmentManager;

    public DesayunoAdapter(Context context, List<ItemDesayuno> items, FragmentManager fragmentManager) {
        this.context = context;
        this.items = items;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        }

        ItemDesayuno currentItem = (ItemDesayuno) getItem(position);

        ImageView icon = convertView.findViewById(R.id.icon);
        TextView title = convertView.findViewById(R.id.title);
        TextView description = convertView.findViewById(R.id.description);
        Button orderButton = convertView.findViewById(R.id.order_button);

        icon.setImageResource(currentItem.getImageResource());
        title.setText(currentItem.getTitle());
        description.setText(currentItem.getDescription());

        return convertView;
    }
}


