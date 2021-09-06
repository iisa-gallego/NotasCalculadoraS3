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
private Button btnConfig;
private EditText editNombre;
private Button btnContinuar;
private ConstraintLayout fondo;

private String colores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfig = findViewById(R.id.bConfig);
        editNombre = findViewById(R.id.editNombre);
        btnContinuar = findViewById(R.id.bContinuar);
        fondo = findViewById(R.id.fondoc);


        btnContinuar.setOnClickListener(
                (view)-> {
                    String nombre = editNombre.getText().toString();


                    Intent i = new Intent(this,CalculoActivity.class);

                    i.putExtra("nombre",nombre);
                    SharedPreferences pre = getSharedPreferences("buzonColor",MODE_PRIVATE);
                    pre.edit().putString("coloreado", colores).apply();

                    startActivity(i);
                }
        );
        btnConfig.setOnClickListener(
                (view)-> {
                    SharedPreferences preferences = getSharedPreferences( "buzonColor",MODE_PRIVATE);
                    preferences.edit().putString("coloreado", colores).apply();
                    Intent p = new Intent(this,ColorActivity.class);
                    startActivityForResult(p,11);
                }
        );

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode == 11 && resultCode == RESULT_OK){

            colores = data.getExtras().getString("color");

            if (colores.equals("Predeterminado")) {
                fondo.setBackgroundColor(Color.rgb(192, 201, 255));
            }
            if (colores.equals("Claro")) {
            fondo.setBackgroundColor(Color.rgb(255, 255, 255));
        }
            if(colores.equals("Oscuro")) {
            fondo.setBackgroundColor(Color.rgb(110,112,124));

        }

        }
    }
}

