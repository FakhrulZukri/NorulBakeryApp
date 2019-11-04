package com.example.loginnorul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    Button bRegister, bBack;
    EditText etName, etIC, etPhone, etEmail, etAddress, etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etIC = (EditText) findViewById(R.id.etIC);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        bBack = (Button) findViewById(R.id.bBack);

        bRegister.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(Register.this, Registered.class)
                );
            }
        }));

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(Register.this, MainActivity.class));
            }
        });
    }

}
