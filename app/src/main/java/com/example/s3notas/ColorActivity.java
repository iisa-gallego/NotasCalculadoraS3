package com.example.s3notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity {
    private Button btnPredet;
    private Button btnClaro;
    private Button btnOscuro;
    private String colores;
    private ConstraintLayout fondoc;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        //Referenciar
        btnPredet = findViewById(R.id.bAzul);
        btnClaro = findViewById(R.id.bBlanco);
        btnOscuro = findViewById(R.id.bNegro);
        fondoc = findViewById(R.id.fondoc);

        SharedPreferences preferencias = getSharedPreferences("buzonColor",MODE_PRIVATE);
colores = preferencias.getString("coloreado","nocoloreado");
        if (colores.equals("Predeterminado")) {
            fondoc.setBackgroundColor(Color.rgb(192, 201, 255));
        }
        if (colores.equals("Claro")) {
            fondoc.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        if(colores.equals("Oscuro")) {
            fondoc.setBackgroundColor(Color.rgb(110,112,124));

        }

        btnPredet.setOnClickListener(
                (view)-> {
                    Intent i = new Intent();
                    i.putExtra("color","Predeterminado");
                    setResult(RESULT_OK,i);
                    finish();

                }
        );
        btnClaro.setOnClickListener(
                (view)->{
                    Intent o = new Intent();
                    o.putExtra("color","Claro");
                    setResult(RESULT_OK,o);
                    finish();

                }
        );
        btnOscuro.setOnClickListener(
                (view)->{
                    Intent p = new Intent();
                    p.putExtra("color","Oscuro");
                    setResult(RESULT_OK,p);
                    finish();


                }

        );
    }
}