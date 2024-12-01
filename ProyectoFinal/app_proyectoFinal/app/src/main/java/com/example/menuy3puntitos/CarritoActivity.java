package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class CarritoActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.cart, container, false);

        // Configurar el ListView
        ListView listView = view.findViewById(R.id.mylist);
        Button continuar = view.findViewById(R.id.contiuar);

        List<ItemCarrito> items = new ArrayList<>();
        items.add(new ItemCarrito("Paquete 1", "$55.00"));
        items.add(new ItemCarrito("Hot Cakes", "$40.50"));
        items.add(new ItemCarrito("Margarita de fresa", "$6.00"));
        items.add(new ItemCarrito("Torta de arrachera", "$30.00"));

        CarritoAdapter adapter = new CarritoAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);

        //Gestionamos el click del boton continuar
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new DetallesPagoActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;


    }
}


