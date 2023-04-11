package com.example.agenda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }
    public void guarda (View view){
        String nombre = et1.getText().toString();
        String datos = et2.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();

        Toast.makeText(this, "el contacto se ha guardado correctamente", Toast.LENGTH_SHORT).show();
    }
    public void buscar (View view){
        String nombre = et1.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", MODE_PRIVATE);
        String dato = preferencias.getString(nombre, "");

        if (dato.length() == 0){
            Toast.makeText(this, "no se han encontado ningun registro", Toast.LENGTH_SHORT).show();
        }else{
            et2.setText(dato);
        }
    }

}
