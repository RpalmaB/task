package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText editTextCedula, editTextNombres, editTextFechaNacimiento, editTextCiudad, editTextCorreo, editTextTelefono;
    public RadioGroup radioGroupGenero;
    public Button buttonLimpiar, buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextCedula = findViewById(R.id.txtCedula);
        editTextNombres = findViewById(R.id.txtNombres);
        editTextFechaNacimiento = findViewById(R.id.txtFechaNac);
        editTextCiudad = findViewById(R.id.txtCiudad);
        editTextCorreo = findViewById(R.id.txtEmail);
        editTextTelefono = findViewById(R.id.txtCelular);
        radioGroupGenero = findViewById(R.id.RdGenero);
        buttonLimpiar = findViewById(R.id.btLimpiar);
        buttonEnviar = findViewById(R.id.btEnviar);

        buttonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });
    }

    public void limpiar() {
        editTextCedula.setText("");
        editTextNombres.setText("");
        editTextFechaNacimiento.setText("");
        editTextCiudad.setText("");
        editTextCorreo.setText("");
        editTextTelefono.setText("");
        radioGroupGenero.clearCheck();
    }

    public void enviar() {
        String cedula = editTextCedula.getText().toString().trim();
        String nombres = editTextNombres.getText().toString().trim();
        String fechaNacimiento = editTextFechaNacimiento.getText().toString().trim();
        String ciudad = editTextCiudad.getText().toString().trim();
        String correo = editTextCorreo.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();

        int selectedRadioButtonId = radioGroupGenero.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String genero = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";

        if (cedula.isEmpty() || nombres.isEmpty() || fechaNacimiento.isEmpty() || ciudad.isEmpty() || correo.isEmpty() || telefono.isEmpty() || genero.isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, MainActivityDatos_usuario.class);
        intent.putExtra("cedula", cedula);
        intent.putExtra("nombres", nombres);
        intent.putExtra("fechaNacimiento", fechaNacimiento);
        intent.putExtra("ciudad", ciudad);
        intent.putExtra("genero", genero);
        intent.putExtra("correo", correo);
        intent.putExtra("telefono", telefono);
        startActivity(intent);
    }


}
