package com.example.menuy3puntitos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class DeliveryActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.delivery, container, false);

        Button btn_volver = view.findViewById(R.id.btn_go_home);

        //BOTON volver al inicio (vista principal)
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Home())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}

