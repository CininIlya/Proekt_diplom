package com.example.avtoapplication.login;





import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avtoapplication.R;

public class ActivityLoginStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);


        Button loginButton = findViewById(R.id.loginBtn);
        Button signButton = findViewById(R.id.sighUpBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
