package com.example.proyectocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private String input = "";
    private double num1 = 0, num2 = 0;
    private char operador = ' ';
    private Calculadora calculadora = new Calculadora();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
    }

    public void botonNumeroClick(View view) {
        Button boton = (Button) view;
        String textoBoton = boton.getText().toString();

        // Evitar que se ingresen múltiples ceros al principio
        if (input.equals("0")) {
            input = textoBoton;
        } else {
            input += textoBoton;
        }

        resultado.setText(input);
    }

    public void botonOperadorClick(View view) {
        Button boton = (Button) view;
        if (!input.isEmpty()) {
            num1 = Double.parseDouble(input);
            operador = boton.getText().toString().charAt(0);

            // Mostrar num1, operador y un espacio en el TextView
            resultado.setText(num1 + " " + operador + " ");

            // Reiniciar input para capturar num2
            input = "";
        }
    }

    public void puntoDecimalClick(View view) {
        if (!input.contains(".")) {
            input += ".";
            resultado.setText(input);
        }
    }

    public void botonIgualClick(View view) {
        if (!input.isEmpty()) {
            num2 = Double.parseDouble(input);
            double resultadoCalculado = 0.0; // Inicializa el resultado a cero

            switch (operador) {
                case '+':
                    resultadoCalculado = calculadora.sumar(num1, num2);
                    break;
                case '-':
                    resultadoCalculado = calculadora.restar (num1, num2);
                    break;
                case '×':
                    resultadoCalculado = calculadora.multiplicar(num1, num2);
                    break;
                case '÷':
                    resultadoCalculado = calculadora.dividir(num1, num2);
                    break;
                case '^':
                    resultadoCalculado = calculadora.potencia(num1, (int) num2);
                    break;
                default:
                    // Manejo de operador desconocido
                    resultadoCalculado = Double.NaN;
            }

            input = String.valueOf(resultadoCalculado);

            if (Double.isNaN(resultadoCalculado)) {
                resultado.setText("ERROR");
            } else {
                resultado.setText(input);
            }
        }
    }

    public void botonResetearClick(View view) {
        num1 = 0;
        num2 = 0;
        operador = ' ';
        input = "";
        resultado.setText("0");
    }

    public void botonFibonacciClick(View view) {
        if (!input.isEmpty()) {
            //obtener numero digitado
            int numeroFibonacci = Integer.parseInt(input);
            //crear lista
            List<Integer> secuenciaFibonacci = calculadora.secuenciaFibonacci(numeroFibonacci);

            //crear intent
            Intent intent = new Intent(this, ActivityResultadoFibonacci.class);

            //pasar numero como extra al intent y convertir lista a string
            intent.putExtra("resultadoFibonacci", secuenciaFibonacci.toString());

            //inicializar intent
            startActivity(intent);
        }
    }

    public void botonFactorialClick(View view) {
        if (!input.isEmpty()) {
            int numeroFactorial = Integer.parseInt(input);
            List<Integer> secuenciaFactorial = calculadora.secuenciaFactorial(numeroFactorial);

            Intent intent = new Intent(this, ActivityResultadoFactorial.class);

            intent.putExtra("resultadoFactorial", secuenciaFactorial.toString());

            startActivity(intent);

        }
    }


}