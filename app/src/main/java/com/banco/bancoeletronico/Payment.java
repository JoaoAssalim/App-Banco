package com.banco.bancoeletronico;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {
    private Button pagar;
    private EditText valor;
    private float cash;
    private GlobalValues globalValues = GlobalValues.getInstance();
    private TextView myCash;

    private void decrementGlobalValueAndUpdateUI(float value) {
        globalValues.decrementGlobalValue(value);
        myCash.setText(String.valueOf(globalValues.getGlobalValue()));
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);getSupportActionBar().hide();
        cash = globalValues.getGlobalValue();
        myCash = findViewById(R.id.saldo);
        String cashStr = String.format("%.2f", cash);
        myCash.setText(cashStr);

        pagar = findViewById(R.id.pagar);


        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor = findViewById(R.id.payment_value);
                valor.setTransformationMethod(null);
                float valor_trans = Float.parseFloat(valor.getText().toString());

                if(valor_trans <= globalValues.getGlobalValue()){
                    decrementGlobalValueAndUpdateUI(valor_trans);
                    exibirAlerta(valor_trans);
                }
            }
        });
    }
    public void exibirAlerta(float valor) {
        Toast toast = Toast.makeText(this, "Transferencia de R$ "+valor, Toast.LENGTH_SHORT);
        toast.show();

    }
}
