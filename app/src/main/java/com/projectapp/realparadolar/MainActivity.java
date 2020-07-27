package com.projectapp.realparadolar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText paraCalcular = findViewById(R.id.valorDecimal);
        final Button calcular = findViewById(R.id.calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.calcular) {
                    String value = paraCalcular.getText().toString();
                    if ("".equals(value)) {
                        Toast.makeText(MainActivity.this,
                                "Opção não reconhecida",
                                Toast.LENGTH_LONG).show();
                    } else {
                        calcularBinario();
                    }
                }
            }
        });
    }

    private void calcularBinario() {
        int value = Integer.parseInt(String.valueOf(R.id.valorDecimal));
        Integer decimal = Integer.valueOf(value);
        int[] m = new int[20];
        int x = 0;

        for (int cont = m.length - 1; cont >= 0; cont--) {
            while (decimal > 1) {
                decimal = decimal / 2;
                m[x] = decimal % 2;
                x++;
            }
            Integer.parseInt(String.valueOf(m[cont]));
        }
    }
}