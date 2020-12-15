package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

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

                    //Toast.makeText(getApplicationContext(),"Hola que tal "+Name+" ",Toast.LENGTH_LONG).show();
                    saludos();
                }
            });




    }

    public void saludos(){
        saludo = ( TextView) findViewById(R.id.saludin);
        enviarDatos("http://192.168.1.70:8080/ServicioBasico/addProducto.php");
        saludo.setText("Hola  "+Name+" Que tal Bienvenidox Tu Apellido es: "+lastName);
        nombre.setText("");
        apellidos.setText("");



    }




    public void enviarDatos(String Url){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion exitosa",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String,String>();
                parametros.put("nombre",Name);
                parametros.put("apellidos",lastName);
                parametros.put("envio", "APP");
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}