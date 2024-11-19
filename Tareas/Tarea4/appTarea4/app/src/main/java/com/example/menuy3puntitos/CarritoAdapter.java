package com.example.menuy3puntitos;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

public class CarritoAdapter extends BaseAdapter {
    private final Context context;
    private final List<ItemCarrito> items;
    private final FragmentManager fragmentManager;


    public CarritoAdapter(Context context, List<ItemCarrito> items,FragmentManager fragmentManager) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_carrito, parent, false);
        }

        ItemCarrito currentItem = (ItemCarrito) getItem(position);

        TextView title = convertView.findViewById(R.id.title);
        TextView precio = convertView.findViewById(R.id.precio);
        Button button_elim = convertView.findViewById(R.id.button_elim);

        title.setText(currentItem.getTitle());
        precio.setText(currentItem.getPrecio());


//        button_elim.setOnClickListener(v -> {
//            if (position == 0) {
//                Paquete1Activity paquete1Fragment = new Paquete1Activity();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, paquete1Fragment)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });
        return convertView;
    }
}


