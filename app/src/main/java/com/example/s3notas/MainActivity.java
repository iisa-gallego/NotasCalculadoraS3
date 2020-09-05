package com.example.s3notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {
private Button bConfig;
private EditText editNombre;
private Button bContinuar;
private ConstraintLayout fondo;

private String colorcitos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //no olvidar referenciar
        bConfig = findViewById(R.id.bConfig);
        editNombre = findViewById(R.id.editNombre);
        bContinuar = findViewById(R.id.bContinuar);
        fondo = findViewById(R.id.fondoc);


        bContinuar.setOnClickListener(
                (view)-> {
                    String nombre = editNombre.getText().toString();


                    Intent i = new Intent(this,CalculoActivity.class);

                    i.putExtra("nombre",nombre);
                    SharedPreferences pre = getSharedPreferences("buzonColor",MODE_PRIVATE);
                    pre.edit().putString("colorin",colorcitos).apply();

                    startActivity(i);

                }
        );
        bConfig.setOnClickListener(
                (view)-> {
                    SharedPreferences preferences = getSharedPreferences( "buzonColor",MODE_PRIVATE);
                    preferences.edit().putString("colorin",colorcitos).apply();
                    Intent p = new Intent(this,ColorActivity.class);
                    startActivityForResult(p,11);

                }
        );

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode == 11 && resultCode == RESULT_OK){

            colorcitos = data.getExtras().getString("color");

            if (colorcitos.equals("Azul")) {
                fondo.setBackgroundColor(Color.rgb(20, 20, 200));
            }
            if (colorcitos.equals("Blanco")) {
            fondo.setBackgroundColor(Color.rgb(200, 200, 200));
        }
            if(colorcitos.equals("Negro")) {
            fondo.setBackgroundColor(Color.rgb(0,0,0));

        }

        }
    }
}

