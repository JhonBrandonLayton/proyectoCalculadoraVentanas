package com.example.proyectocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityResultadoFactorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_factorial);

        String resultadoFactorial = getIntent().getStringExtra("resultadoFactorial");

        TextView textViewResultadoFactorial = findViewById(R.id.textViewResultadoFactorial);

        textViewResultadoFactorial.setText("Secuencia Factorial: " + resultadoFactorial);

        ImageView regresarIcono = findViewById(R.id.regresarIcono);
        regresarIcono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }




}