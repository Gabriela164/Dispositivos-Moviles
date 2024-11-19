package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class TortasActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tortas, container, false);

        ListView listView = view.findViewById(R.id.mylist);

        //Usamos el mismo adapter e item de BreakFast (la funcion es la misma)
        List<ItemTortas> items = new ArrayList<>();
        items.add(new ItemTortas("Torta de pastor", "$75.00", R.drawable.torta1));
        items.add(new ItemTortas("Pambazo", "$100.50", R.drawable.torta2));
        items.add(new ItemTortas("Torta de jamón", "$26.00", R.drawable.torta3));
        items.add(new ItemTortas("Torta de arrachera", "$32.00", R.drawable.torta4));

        TortasAdapter adapter = new TortasAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);

        return view;
    }
}