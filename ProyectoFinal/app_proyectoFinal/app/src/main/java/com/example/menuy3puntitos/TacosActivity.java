package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class TacosActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tacos, container, false);

        ListView listView = view.findViewById(R.id.mylist);

        //Usamos el mismo adapter e item de BreakFast (la funcion es la misma)
        List<ItemTacos> items = new ArrayList<>();
        items.add(new ItemTacos("Tacos de suadero", "$75.00", R.drawable.tacos1));
        items.add(new ItemTacos("Tacos al pastor", "$100.50", R.drawable.tacos2));
        items.add(new ItemTacos("Tacos de cochinita pibil", "$26.00", R.drawable.tacos3));
        items.add(new ItemTacos("Tacos de carnitas", "$32.00", R.drawable.tacos4));

        TacosAdapter adapter = new TacosAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);

        return view;
    }
}