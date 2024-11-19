package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class PromoActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.promo, container, false);

        // Configurar el ListView
        ListView listView = view.findViewById(R.id.mylist);

        List<PromoItem> promoItems = new ArrayList<>();
        promoItems.add(new PromoItem("PROMOCIÓN 1", "$55.00", "Ahorra hasta un 35%", R.drawable.promo1));
        promoItems.add(new PromoItem("PROMOCIÓN 2", "$40.50","Ahorra hasta un 25%", R.drawable.promo2));
        promoItems.add(new PromoItem("PROMOCIÓN 3", "$26.00", "Ahorra hasta un 15%", R.drawable.promo3));
        promoItems.add(new PromoItem("PROMOCIÓN 4", "$30.00","Ahorra hasta un 40%", R.drawable.promo4));

        PromoAdapter adapter = new PromoAdapter(getContext(), promoItems);
        listView.setAdapter(adapter);
        return view;
    }
}



