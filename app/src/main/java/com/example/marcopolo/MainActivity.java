package com.example.marcopolo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button marcoButton;
        Button poloButton;
        final String[] status = new String[1];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marcoButton = findViewById(R.id.marcoButton);
        poloButton = findViewById(R.id.poloButton);

        marcoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status[0] = "Marco!";

                // Start Activity
                Intent intent = ScreenActivity.newIntent(MainActivity.this, status[0]);
                startActivity(intent);

            }
        });

        poloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status[0] = "Polo!";

                // Start Activity
                Intent intent = ScreenActivity.newIntent(MainActivity.this, status[0]);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK){
            Log.d(TAG, "Success");
            return;
        }
        else{
            Log.d(TAG, "Failure");
            return;
        }

    }
}