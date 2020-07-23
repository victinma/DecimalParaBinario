package com.projectapp.realparadolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewHolder.valor.findViewById(R.id.valorBinario);
        this.viewHolder.paraCalcular.findViewById(R.id.valorDecimal);
        this.viewHolder.calcularButton.setOnClickListener(this);
        this.limpar();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.calcular){
            String value = this.viewHolder.paraCalcular
                    .getText().toString();
            if("".equals(value)){
                Toast.makeText(this,
                        "informe um valor", Toast.LENGTH_LONG).show();
            }else{
                calcularBinario();
            }
        }
    }

    private void limpar() {
        this.viewHolder.valor.setText("");
        this.viewHolder.paraCalcular.setText("");
    }

    private static class ViewHolder{
        EditText valor;
        EditText paraCalcular;
        Button calcularButton;
    }

    private void calcularBinario(){
        int value = Integer.parseInt(String.valueOf
                (viewHolder.paraCalcular));
        Integer decimal = Integer.valueOf(value);
        int[] m = new int[10];
        int x = 0;
        while (decimal>1){
            m[x] = decimal % 2;
            decimal = decimal/2;
            x++;
        }

        for (int cont = m.length-1; cont>=0; cont--){
            System.out.print(m[cont]);
        }
    }
}