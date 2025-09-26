package com.example.avtoapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.avtoapplication.login.ActivityLoginStart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {



    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton fab = findViewById(R.id.Button_gallery);
        ImageButton startbaza = findViewById(R.id.loginBtnStart);


// переход на Галлерею
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Gallery.class);
                intent.putExtra("isEditMode", false);
                startActivity(intent);
            }
        });

        // переход на базу клиентов
startbaza.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityLoginStart.class);
        intent.putExtra("Успешно",false);
        startActivity(intent);
    }
});
    }
}