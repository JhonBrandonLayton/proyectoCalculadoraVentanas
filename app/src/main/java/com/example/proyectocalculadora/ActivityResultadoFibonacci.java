package com.example.proyectocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ActivityResultadoFibonacci extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_fibonacci);

        //recuperar el numero obtenido en la anterior activity
        String resultadoFibonacci = getIntent().getStringExtra("resultadoFibonacci");

        //crear vista del textview
        TextView textViewResultadoFibonacci = findViewById(R.id.textViewResultadoFibonacci);

        //Mostrar resultado en el textview
        textViewResultadoFibonacci.setText("Secuencia Fibonacci: "+resultadoFibonacci);

        ImageView regresarIcono = findViewById(R.id.regresarIcono);

        regresarIcono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }


}