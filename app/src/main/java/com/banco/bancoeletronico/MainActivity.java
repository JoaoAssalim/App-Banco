package com.banco.bancoeletronico;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView pay;
    private ImageView profile;
    private float cash;
    private GlobalValues globalValues = GlobalValues.getInstance();
    private TextView myCash;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        globalValues.setGlobalValue(4200f);

        getSupportActionBar().hide();

        pay = findViewById(R.id.bt_pay);
        profile = findViewById(R.id.profile_picture);



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPayment();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProfile();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cash = globalValues.getGlobalValue();
        myCash = findViewById(R.id.cash_account);
        String cashStr = String.format("%.2f", cash);
        myCash.setText(cashStr);
    }

    private void goProfile(){
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);
    }

    private void goPayment(){
        Intent intent = new Intent(MainActivity.this, Payment.class);
        startActivity(intent);
    }
}
