package com.example.menuy3puntitos;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PromoAdapter extends BaseAdapter {
    private final Context context;
    private final List<PromoItem> items;

    public PromoAdapter(Context context, List<PromoItem> items) {
        this.context = context;
        this.items = items;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_promo, parent, false);
        }

        PromoItem currentItem = (PromoItem) getItem(position);

        ImageView icon = convertView.findViewById(R.id.icon);
        TextView title = convertView.findViewById(R.id.title);
        TextView description = convertView.findViewById(R.id.description);
        TextView descuento = convertView.findViewById(R.id.descuento_obtenido);
        Button orderButton = convertView.findViewById(R.id.order_button);

        icon.setImageResource(currentItem.getImageResource());
        title.setText(currentItem.getTitle());
        description.setText(currentItem.getDescription());
        descuento.setText(currentItem.getDescuento());

        orderButton.setOnClickListener(v -> {
            // Lógica para el botón "Ordenar"
            // Por ejemplo, mostrar un Toast o realizar una acción
        });

        return convertView;
    }
}



