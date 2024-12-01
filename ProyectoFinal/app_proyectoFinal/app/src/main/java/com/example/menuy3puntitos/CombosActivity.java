package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class CombosActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.packages, container, false);

        // Configurar el ListView
        ListView listView = view.findViewById(R.id.mylist);

        List<ItemCombo> items = new ArrayList<>();
        items.add(new ItemCombo("PAQUETE 1: INDIVIDUAL", "$55.00", R.drawable.paquete1));
        items.add(new ItemCombo("PAQUETE 2: DOS PERSONAS", "$40.50", R.drawable.paquete2));
        items.add(new ItemCombo("PAQUETE 3: FAMILIAR", "$6.00", R.drawable.paquete3));
        items.add(new ItemCombo("PAQUETE 4: TRES PERSONAS", "$30.00", R.drawable.paquete4));

        CombosAdapter adapter = new CombosAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);
        return view;
    }
}


