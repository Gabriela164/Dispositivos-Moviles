package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class BebidasActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bebidas, container, false);

        ListView listView = view.findViewById(R.id.mylist);

        //Usamos el mismo adapter e item de BreakFast (la funcion es la misma)
        List<ItemBebida> items = new ArrayList<>();
        items.add(new ItemBebida("Limonada de Limón", "$75.00", R.drawable.bebida1));
        items.add(new ItemBebida("Margarita de fresa", "$100.50", R.drawable.bebida2));
        items.add(new ItemBebida("Frapucchino de uva", "$206.00", R.drawable.bebida3));
        items.add(new ItemBebida("Bubble te de mora", "$302.00", R.drawable.bebida4));

        BebidaAdapter adapter = new BebidaAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);
        return view;
    }
}
