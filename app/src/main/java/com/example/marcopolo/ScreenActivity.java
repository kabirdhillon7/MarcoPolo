package com.example.marcopolo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ScreenActivity extends AppCompatActivity {
    private String currentStatus;
    public static final String TAG = "ScreenActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_activity);

        TextView statusTextView;
        statusTextView = findViewById(R.id.statusTextView);

        currentStatus = getIntent().getStringExtra("Current Status");
        statusTextView.setText(currentStatus);

        if (currentStatus.equals("Marco!")){
            setResult("Marco");
        }
        else if (currentStatus.equals("Polo!")){
            setResult("Polo");
        }
    }

    public void setResult(String postStatus) {
        // Sending back data
        Intent data = new Intent();
        data.putExtra("Return Data", postStatus);
        setResult(RESULT_OK, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // We're overriding our back button, and checking if it was clicked
        if(keyCode == KeyEvent.KEYCODE_BACK){
            /* To check what our current status is,
            and based on that present the
            correct toast.
             */
            currentStatus = getIntent().getStringExtra("Current Status");
            Log.d(TAG, "Success");

            if(currentStatus.equals("Marco!")){
                Toast.makeText(ScreenActivity.this,
                        R.string.polo_button_toast,
                        Toast.LENGTH_SHORT).show();
            }
            else if(currentStatus.equals("Polo!")){
                Toast.makeText(ScreenActivity.this,
                        R.string.marco_button_toast,
                        Toast.LENGTH_SHORT).show();
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    public static Intent newIntent(Context packageContext, String status){
        Intent intent = new Intent(packageContext, ScreenActivity.class);
        intent.putExtra("Current Status", status);

        return intent;
    }
}
