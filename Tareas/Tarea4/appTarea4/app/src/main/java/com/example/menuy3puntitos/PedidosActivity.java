package com.example.menuy3puntitos;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


public class PedidosActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.pedidos, container, false);

        // Configurar el ListView
        ListView listView = view.findViewById(R.id.mylist);

        List<ItemPedido> items = new ArrayList<>();
        items.add(new ItemPedido("PEDIDO 1", "$155.00", "10/10/24"));
        items.add(new ItemPedido("PEDIDO 2", "$140.50", "14/10/24"));
        items.add(new ItemPedido("PEDIDO 3", "$600.00", "15/10/24"));
        items.add(new ItemPedido("PEDIDO 4", "$300.00", "17/10/24"));

        PedidoAdapter adapter = new PedidoAdapter(getContext(), items, getParentFragmentManager());
        listView.setAdapter(adapter);
        return view;
    }
}



