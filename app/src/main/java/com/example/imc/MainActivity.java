package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText peso;
    private EditText altura;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.pesoEditText);
        altura = findViewById(R.id.alturaEditText);
        button = findViewById(R.id.calcularButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double pesoInput = Double.parseDouble(peso.getText().toString());
                double alturaInput = Double.parseDouble(altura.getText().toString());

                Log.d("Button", "Cliquei");

                Intent intent = new Intent(MainActivity.this, CalculoActivity.class);
                intent.putExtra("Peso", pesoInput);
                intent.putExtra("Altura", alturaInput);
                startActivity(intent);
            }
        });

    }
}
