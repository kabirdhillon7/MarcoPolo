package com.example.marcopolo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button marcoButton;
        Button poloButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marcoButton = findViewById(R.id.marcoButton);
        poloButton = findViewById(R.id.poloButton);

        marcoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        R.string.marco_button_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        poloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        R.string.polo_button_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}