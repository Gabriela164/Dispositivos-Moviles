package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class DesayunoActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.list_breakfast, container, false);

        // Configurar el ListView
        ListView listView = view.findViewById(R.id.mylist);

        List<ItemDesayuno> items = new ArrayList<>();
        items.add(new ItemDesayuno("Chilaquiles", "$55.00", R.drawable.chilaquiles));
        items.add(new ItemDesayuno("Hot Cakes", "$40.50", R.drawable.hotcakes));
        items.add(new ItemDesayuno("Huevos a la mexicana", "$6.00", R.drawable.huevos));
        items.add(new ItemDesayuno("Café y pan", "$30.00", R.drawable.cafeypan));

        DesayunoAdapter adapter = new DesayunoAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);

        return view;
    }
}



