package com.example.avtoapplication.login;


import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.example.avtoapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class ActivityLoginStart extends AppCompatActivity {

    private int anycolor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);




//        ImageButton loginButton = findViewById(R.id.loginBtn);
//        loginButton.setBackgroundColor(Color.TRANSPARENT);

    //        ImageButton loginButton = findViewById(R.id.loginBtn);
//        loginButton.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint

//



//        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
//
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ActivityLoginStart.this, "ImageButton is clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(ActivityLoginStart.this,
                        "Добро пожаловать",
                        Toast.LENGTH_SHORT).show();
                imageButton.requestFocus();
//                Intent intent = new Intent(ActivityLoginStart.this, LoginActivity.class);
//                startActivity(intent);

                int timeout = 1000; //задержка на странице 1 сек
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        finish();
                        Intent homepage = new Intent(ActivityLoginStart.this, LoginActivity.class);
                        startActivity(homepage);
                    }
                }, timeout);
            }

        });


//        loginButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                boolean b = loginButton.isSelected() != loginButton.isSelected();
//
//                loginButton.setBackgroundResource(R.drawable.login3);
//                Toast.makeText(ActivityLoginStart.this, "ImageButton is clicked", Toast.LENGTH_SHORT).show();
//
//
//                Intent intent = new Intent(ActivityLoginStart.this, LoginActivity.class);
//                startActivity(intent);

//            }
//        });
//ImageButton signButton = findViewById(R.id.sighUpBtn);

//        loginButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                boolean b = loginButton.isSelected() != loginButton.isSelected();
//
//                loginButton.setBackgroundResource(R.drawable.login3);
//                Toast.makeText(ActivityLoginStart.this, "ImageButton is clicked", Toast.LENGTH_SHORT).show();
//
//
//                Intent intent = new Intent(ActivityLoginStart.this, LoginActivity.class);
//                startActivity(intent);

//            }
//        });
//
        ImageButton signButton = findViewById(R.id.sighUpBtn);
        signButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLoginStart.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }
}
