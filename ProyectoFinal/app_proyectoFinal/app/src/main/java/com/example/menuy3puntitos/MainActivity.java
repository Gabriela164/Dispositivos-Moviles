package com.example.menuy3puntitos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.util.Log;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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

        // Colocamos el fragmento de inicio (Home) al inicio
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new Home()) // Coloca el fragmento de inicio por defecto
                    .commit();
        }

        DrawerLayout drawer = binding.drawerLayout;
        navigationView = binding.navView;

        // Habilitamos el ícono del menú
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.baseline_menu_24);
        }

        // Manejamos los clicks del menú desplegable izquierdo
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = null;

                if (id == R.id.op_menu) {
                    fragment = new Home();
                } else if (id == R.id.op_offer) {
                    fragment = new PromoActivity(); //Cambiamos aqui xd
                } else if (id == R.id.op_pack) {
                    fragment = new CombosActivity();
                } else if (id == R.id.op_cart) {
                    fragment = new CarritoActivity(); //De nuevo se me olvido cambiar aqui y estuve batallando un ratote XD
                } else {
                    Log.e("Menu desplegable IZQ", "Opción desconocida seleccionada");
                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
                // Cierra el drawer una vez se selecciona una opción
                drawer.closeDrawer(GravityCompat.START);
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
        Fragment fragment = null;

        if (id == R.id.op1) {
            fragment = new SettingsFragment();
        } else if (id == R.id.op2) {
            fragment = new PedidosActivity();
        } else if (id == R.id.op3) {
            fragment = new HelpFragment();
        }

        if (fragment != null) {
            // Reemplazamos el fragmento en el contenedor
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
