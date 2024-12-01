package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class PostresActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.postres, container, false);

        ListView listView = view.findViewById(R.id.mylist);

        //Usamos el mismo adapter e item de BreakFast (la funcion es la misma)
        List<ItemPostre> items = new ArrayList<>();
        items.add(new ItemPostre("Churros con nutella", "$45.00", R.drawable.postre1));
        items.add(new ItemPostre("Deliciosas donas", "$70.50", R.drawable.postre2));
        items.add(new ItemPostre("Crepa de nutella con fresas", "$126.00", R.drawable.postre3));
        items.add(new ItemPostre("Pastel de 3 leches y fresas", "$132.00", R.drawable.postre4));

        PostreAdapter adapter = new PostreAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);

        return view;
    }
}