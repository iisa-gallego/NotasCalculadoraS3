package com.example.s3notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity {
    private Button bAzul;
    private Button bBlanco;
    private Button bNegro;
    private String colorcitos;
    private ConstraintLayout fondoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        //Referenciar
        bAzul = findViewById(R.id.bAzul);
        bBlanco = findViewById(R.id.bBlanco);
        bNegro = findViewById(R.id.bNegro);
        fondoc = findViewById(R.id.fondoc);

        SharedPreferences preferencias = getSharedPreferences("buzonColor",MODE_PRIVATE);
colorcitos = preferencias.getString("colorin","nocolorin");
        if (colorcitos.equals("Azul")) {
            fondoc.setBackgroundColor(Color.rgb(20, 20, 200));
        }
        if (colorcitos.equals("Blanco")) {
            fondoc.setBackgroundColor(Color.rgb(200, 200, 200));
        }
        if(colorcitos.equals("Negro")) {
            fondoc.setBackgroundColor(Color.rgb(20,20,200));

        }

        bAzul.setOnClickListener(
                (view)-> {
                    Intent i = new Intent();
                    i.putExtra("color","Azul");
                    setResult(RESULT_OK,i);
                    finish();

                }
        );
        bBlanco.setOnClickListener(
                (view)->{
                    Intent o = new Intent();
                    o.putExtra("color","Blanco");
                    setResult(RESULT_OK,o);
                    finish();

                }
        );
        bNegro.setOnClickListener(
                (view)->{
                    Intent p = new Intent();
                    p.putExtra("color","Negro");
                    setResult(RESULT_OK,p);
                    finish();


                }

        );
    }
}