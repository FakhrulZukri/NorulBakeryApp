package com.example.loginnorul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registered extends AppCompatActivity {

    Button bLoginAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        bLoginAgain = (Button) findViewById(R.id.bLoginAgain);

        bLoginAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registered.this, MainActivity.class));
            }
        });


    }
}
