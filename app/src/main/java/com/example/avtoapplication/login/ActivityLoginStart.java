package com.example.avtoapplication.login;





import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avtoapplication.R;

public class ActivityLoginStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);


        ImageButton loginButton = findViewById(R.id.loginBtn);
//        loginButton.setBackgroundColor(Color.TRANSPARENT);

//        ImageButton loginButton = (ImageButton) this.findViewById(R.id.loginBtn);
//        loginButton.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint

        Button signButton = findViewById(R.id.sighUpBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityLoginStart.this, "ImageButton is clicked", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(ActivityLoginStart.this, LoginActivity.class);
        startActivity(intent);

            }
        });

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLoginStart.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
