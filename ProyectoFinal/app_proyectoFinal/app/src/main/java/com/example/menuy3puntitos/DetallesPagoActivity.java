package com.example.menuy3puntitos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.List;

public class DetallesPagoActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_activity, container, false);


        //Recuperamos la información proporcionada por el usuario.
        TextView total = view.findViewById(R.id.digit);
        RadioGroup paymentOptions = view.findViewById(R.id.payment_options);
        EditText cardNumber = view.findViewById(R.id.editText_number_card);
        EditText expiryDate = view.findViewById(R.id.date_box);
        EditText cvv = view.findViewById(R.id.editText_cvv);
        EditText name = view.findViewById(R.id.editText_name);
        CheckBox saveCardCheckbox = view.findViewById(R.id.checkBox);
        Button pay = view.findViewById(R.id.button);


        pay.setOnClickListener(v -> {
            //Recuperamos la información proporcionada por el usuario.
            String total_string = total.getText().toString();
            String cardNum = cardNumber.getText().toString();
            String expiry = expiryDate.getText().toString();
            String cvvCode = cvv.getText().toString();
            String userName = name.getText().toString();
            boolean saveCard = saveCardCheckbox.isChecked();
            int selectedOptionId = paymentOptions.getCheckedRadioButtonId();
            String paymentMethod = "";
            if (selectedOptionId != -1) {
                RadioButton selectedOption = view.findViewById(selectedOptionId);
                paymentMethod = selectedOption.getText().toString();
            }

            //Convertimos los datos proporcionados por el usuario en un objeto de tipo DatosTarjeta
            DatosTarjeta nuevoDato = new DatosTarjeta(total_string, paymentMethod, cardNum, expiry, cvvCode, userName, String.valueOf(saveCard));
            //Creamos la base de datos
            DatosTarjetaBDD datosTarjetaBDD = new DatosTarjetaBDD(getContext());
            datosTarjetaBDD.openForWrite();
            long result = datosTarjetaBDD.insertDato(nuevoDato);

            List<DatosTarjeta> alldatos = datosTarjetaBDD.getAll();

            if (result != -1) {
                //Mostramos un mensaje de que los datos han sido capturados exitosamente
                Toast.makeText(getContext(), "Datos guardados correctamente", Toast.LENGTH_SHORT).show();

                //Mostramos TODOS los datos que hayamos guardado en nuestra tabla de nuestra BD en logCat
                for(DatosTarjeta dato: alldatos){
                    Log.d("DatosGuardados", "Propietario: "+ dato.getPropietario() + " Total: " + dato.getTotal() + " Metodo de pago: " + dato.getMetodoDePago() + " Guardar datos?: " + dato.getGuardarDatos());
                }

                // Reemplazar el fragmento actual con la vista Delivery (gracias por su compra)
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new DeliveryActivity())
                            .addToBackStack(null)
                            .commit();
                }
            } else {
                //En caso, de que no hayamos podido guardar de forma exitosa los datos en la BD.
                Toast.makeText(getContext(), "Error al guardar los datos", Toast.LENGTH_SHORT).show();
            }
            datosTarjetaBDD.close(); //Cerramos la BD
        });
        return view;
    }
}
