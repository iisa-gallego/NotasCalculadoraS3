package com.example.s3notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultadoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView muestraNombre;
    private TextView muestraResultado;
    private Button calcularOtraVez;
    private ConstraintLayout fondomu ;
    private String col;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String nombre = getIntent().getExtras().getString("nombre");



        muestraNombre = findViewById(R.id.muestraNombre);
                muestraResultado= findViewById(R.id.muestraResultado);
                calcularOtraVez = findViewById(R.id.calculaOtraVez);
                fondomu = findViewById(R.id.fondomu);

        SharedPreferences preferencias = getSharedPreferences("buzonColor",MODE_PRIVATE);
        col = preferencias.getString("coloreado","nocoloreado");
        if (col.equals("Predeterminado")) {
            fondomu.setBackgroundColor(Color.rgb(192, 201, 255));
        }
        if (col.equals("Claro")) {
            fondomu.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        if(col.equals("Oscuro")) {
            fondomu.setBackgroundColor(Color.rgb(110,112,124));

        }

      double noticas = getIntent().getExtras().getDouble("notas");
        DecimalFormat decimales = new DecimalFormat("#.00");

        muestraResultado.setText("" + decimales.format( noticas));
        Log.d("pasaste",""+ noticas);


               muestraNombre.setText(nombre);

                calcularOtraVez.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.calculaOtraVez:


                Intent u = new Intent(this,MainActivity.class);
                startActivity(u);

                break;

        }

    }
}