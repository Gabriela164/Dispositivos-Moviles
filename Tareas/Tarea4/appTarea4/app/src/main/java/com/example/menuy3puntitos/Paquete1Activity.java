package com.example.menuy3puntitos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Paquete1Activity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.first_activity, container, false);

        Button agregar_a_carrito = view.findViewById(R.id.add_to_cart);

        //BOTON DE POSTRES
        agregar_a_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new CarritoActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;



    }
}
