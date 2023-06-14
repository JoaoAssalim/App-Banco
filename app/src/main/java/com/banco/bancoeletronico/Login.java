package com.banco.bancoeletronico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailinput);
        senha = findViewById(R.id.payment_value);
        login = findViewById(R.id.pagar);

        getSupportActionBar().hide();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailCadastrado = "";
                String senhaCadastrada = "";

                String emailAtual = email.getText().toString();
                String senhaAtual = senha.getText().toString();

                if (senhaAtual.equals(senhaCadastrada) && emailAtual.equals(emailCadastrado)){
                    goMainActivity();
                }else{
                    Toast.makeText(Login.this, "Login Invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goMainActivity(){
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}