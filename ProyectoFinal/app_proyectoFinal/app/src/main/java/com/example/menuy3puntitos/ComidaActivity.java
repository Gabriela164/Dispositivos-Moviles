package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class ComidaActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comida, container, false);

        ListView listView = view.findViewById(R.id.mylist);

        //Usamos el mismo adapter e item de BreakFast (la funcion es la misma)
        List<ItemComida> items = new ArrayList<>();
        items.add(new ItemComida("Pozole", "$55.00", R.drawable.comida1));
        items.add(new ItemComida("Enchiladas", "$90.50", R.drawable.comida2));
        items.add(new ItemComida("Chile en Nogada", "$86.00", R.drawable.comida3));
        items.add(new ItemComida("Enfrijoladas", "$60.00", R.drawable.comida4));

        ComidaAdapter adapter = new ComidaAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);

        return view;
    }
}
