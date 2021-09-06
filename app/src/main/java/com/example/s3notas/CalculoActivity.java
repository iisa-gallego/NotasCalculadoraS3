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
import android.widget.EditText;


public class CalculoActivity extends AppCompatActivity {
    private EditText editActividad1;
    private EditText editActividad2;
    private EditText editQuizz;
    private EditText editParcial1;
    private EditText editParcial2;
    private Button bCalcular;
    private EditText editSemanal;
    private ConstraintLayout fondocal;
    private String colo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);


        editActividad1 = findViewById(R.id.editProyecto1);
        editActividad2 = findViewById(R.id.editProyecto2);
        editQuizz = findViewById(R.id. editQuizz);
        editParcial1 = findViewById(R.id.editParcial1);
        editParcial2 = findViewById(R.id.editParcial2);
        bCalcular = findViewById(R.id.bCalcular);
        editSemanal = findViewById(R.id.editSemanal);
        fondocal = findViewById(R.id.fondocal);

        SharedPreferences preferencias = getSharedPreferences("buzonColor",MODE_PRIVATE);
        colo = preferencias.getString("coloreado","nocoloreado");
        if (colo.equals("Predeterminado")) {
            fondocal.setBackgroundColor(Color.rgb(192, 201, 255));
        }
            if (colo.equals("Claro")) {
            fondocal.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        if(colo.equals("Oscuro")) {
            fondocal.setBackgroundColor(Color.rgb(110,112,124));

        }

        String nombre = getIntent().getExtras().getString("nombre");

        // editProyecto1.setText(nombre);

         bCalcular.setOnClickListener(


                 (v)->{
                    String proyecto1 = editActividad1.getText().toString();
                     String proyecto2 = editActividad2.getText().toString();
                     String quizz = editQuizz.getText().toString();
                     String parcial1 = editParcial1.getText().toString();
                     String parcial2 = editParcial2.getText().toString();
                     String semanal = editSemanal.getText().toString();



                     double pro1 = Double.parseDouble(proyecto1);
                     double pro2 = Double.parseDouble(proyecto2);
                     double quiz = Double.parseDouble(quizz);
                     double par1 = Double.parseDouble(parcial1);
                     double par2 = Double.parseDouble(parcial2);
                     double sem = Double.parseDouble(semanal);

                     double calif = (pro1*0.25)+(pro2*0.25)+(quiz*0.15)+(par1*0.15)+(par2*0.15)+(sem*0.05);
                     Intent y = new Intent(this,ResultadoActivity.class);
                     y.putExtra("notas",calif);
                     startActivity(y);

                     Log.d("calculo","" + calif);
                     Log.d("notas","" + pro1 );





                     y.putExtra("nombre",nombre);

                     startActivity(y);

                 }
         );

    }
    }