package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    TextView  saludo;
    EditText nombre, apellidos;
    Button btn;

     public String Name, lastName;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nameText);
        apellidos = (EditText) findViewById(R.id.apellidoText);

        this.iniciar();



    }



    public void iniciar(){

            saludo = ( TextView) findViewById(R.id.saludin);
            saludo.setText("Hola Que tal Bienvenido");

            btn = (Button) findViewById(R.id.btn_hola);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                         lastName =  apellidos.getText().toString();
                         Name = nombre.getText().toString();

                    Toast.makeText(getApplicationContext(),"Hola que tal "+Name+" ",Toast.LENGTH_LONG).show();
                    saludos();
                }
            });




    }

    public void saludos(){
        saludo = ( TextView) findViewById(R.id.saludin);
        saludo.setText("Hola  "+Name+" Que tal Bienvenido Tu Apellido es: "+lastName);
    }
}