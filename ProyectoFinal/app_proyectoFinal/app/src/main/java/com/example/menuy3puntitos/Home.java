package com.example.menuy3puntitos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class Home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inicio, container, false);

        Button btn1 = view.findViewById(R.id.btn1);
        Button btn2 = view.findViewById(R.id.btn2);
        Button btn3 = view.findViewById(R.id.btn3);
        Button btn4 = view.findViewById(R.id.btn4);
        Button btn5 = view.findViewById(R.id.btn5);
        Button btn6 = view.findViewById(R.id.btn6);

        //BOTON DE DESAYUNOS
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new DesayunoActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });

        //BOTON DE COMIDA
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new ComidaActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });

        //BOTON DE TACOS
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new TacosActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });


        //BOTON DE TORTAS
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new TortasActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });

        //BOTON DE BEBIDAS
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new BebidasActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });

        //BOTON DE POSTRES
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new PostresActivity())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
