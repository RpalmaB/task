package com.example.task;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDatos_usuario extends AppCompatActivity {

    public TextView txtDatosUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_datos_usuario);

        txtDatosUsu = findViewById(R.id.txtDatos);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String cedula = extras.getString("cedula");
            String nombres = extras.getString("nombres");
            String fechaNacimiento = extras.getString("fechaNacimiento");
            String ciudad = extras.getString("ciudad");
            String genero = extras.getString("genero");
            String correo = extras.getString("correo");
            String telefono = extras.getString("telefono");


           String DatosI = "Cédula: " + cedula + "\n" + "Nombres: " + nombres + "\n" + "Fecha Nacimiento: " + fechaNacimiento + "\n" +
                    "Ciudad: " + ciudad + "\n" + "Género: " + genero + "\n" + "Correo: " + correo + "\n" + "Telefono: " + telefono;

           txtDatosUsu.setText(DatosI);
        }
    }
}
