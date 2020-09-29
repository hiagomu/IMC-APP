package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculoActivity extends AppCompatActivity {

    private TextView imc;
    private TextView estado;
    private Button button;
    private String textEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        imc = findViewById(R.id.imcTextView);
        estado = findViewById(R.id.estadoTextView);
        button = findViewById(R.id.homeButton);

        Intent intent = getIntent();

        double nPeso = intent.getDoubleExtra("Peso", 0);
        double nAltura = intent.getDoubleExtra("Altura", 0);

        double nIMC = nPeso/(nAltura*nAltura);
        imc.setText(Double.toString(nIMC));

        if (nIMC < 18.5) {
            textEstado = "Abaixo do peso";
        } else if (nIMC >= 18.6 && nIMC <= 24.9) {
            textEstado = "Peso ideal";
        } else  if (nIMC >= 25 && nIMC <= 29.9) {
            textEstado = "Levemente acima do peso";
        } else if (nIMC >= 30 && nIMC <= 34.9) {
            textEstado = "Obesidade grau I";
        } else if (nIMC >= 35 && nIMC <=39.9) {
            textEstado = "Obesidade gray II (severa)";
        } else if (nIMC >= 40) {
            textEstado = "Obesidade III (mórbida)";
        } else {
            textEstado = "ERRO 404 :(";
        }
        estado.setText(textEstado);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
