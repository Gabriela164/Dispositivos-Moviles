package com.example.menuy3puntitos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;
import com.example.menuy3puntitos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        navigationView = binding.navView;

        // Habilitamos el ícono del menú
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false); //Deshabilitamos el titulo de app_bar
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_menu_24);
        }


        // Manejamos los clicks del menú desplegable izquierdo
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //Obtenemos el id del elemento seleccionado
                int id = item.getItemId();

                if (id == R.id.op_menu) {
                    Log.e("Menu desplegable IZQ", "Seleccionaste: Menú principal");
                } else if (id == R.id.op_offer) {
                    Log.e("Menu desplegable IZQ", "Seleccionaste: Promociones");
                } else if (id == R.id.op_pack) {
                    Log.e("Menu desplegable IZQ", "Seleccionaste: Paquetes");
                } else if (id == R.id.op_pay) {
                    Log.e("Menu desplegable IZQ", "Seleccionaste: Realizar pago");
                } else {
                    Log.e("Menu desplegable IZQ", "Opción desconocida seleccionada");
                }
                drawer.closeDrawer(navigationView);
                return true;
            }
        });

        // Listener para abrir el drawer
        binding.appBarMain.toolbar.setNavigationOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //Manejamos los click del menu superior (3 puntitos)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.op1) {
            Log.e("MainActivity", "Seleccionaste la opción 1: Ajustes de cuenta");
        } else if(id == R.id.op2) {
            Log.e("MainActivity", "Seleccionaste la opción 2: Historial de pedidos");
        } else if(id == R.id.op3) {
            Log.e("MainActivity", "Seleccionaste la opción 3: Ayuda y soporte");
        }
        return super.onOptionsItemSelected(item);
    }
}
