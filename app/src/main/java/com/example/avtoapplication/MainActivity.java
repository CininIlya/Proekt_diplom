package com.example.avtoapplication;

import static android.widget.Toast.*;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.avtoapplication.login.ActivityLoginStart;
import com.example.avtoapplication.login.LoginActivity;
import com.example.avtoapplication.login.SignUpActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton fab = findViewById(R.id.Button_gallery);
        ImageButton startbaza = findViewById(R.id.loginBtnStart);
        ImageButton what = findViewById(R.id.whatsss);


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
                intent.putExtra("Успешно", false);
                startActivity(intent);
            }
        });
// переход whatsup

        what.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlToShare = "https://example.com";

                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                whatsappIntent.setPackage("com.whatsapp");

                Intent telegramIntent = new Intent(Intent.ACTION_SEND);
                telegramIntent.setType("text/plain");
                telegramIntent.putExtra(Intent.EXTRA_TEXT, urlToShare);
                telegramIntent.setPackage("org.telegram.messenger");

                Intent chooserIntent = Intent.createChooser(whatsappIntent, "Поделиться через...");

                Intent[] extraIntents = { telegramIntent };
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);

                try {
                    startActivity(chooserIntent);
                } catch (ActivityNotFoundException e) {
                    makeText(MainActivity.this, "Установите WhatsApp или Telegram", LENGTH_SHORT).show();
                }
            }


//            @Override
//            public void shareLink() {
//                Intent myIntent = new Intent(Intent.ACTION_SEND);
//                myIntent.setType("text/plain");
//                myIntent.putExtra(Intent.EXTRA_TEXT, "https://dream.com");
//                myIntent.setPackage("org.telegram.messenger");
//
//                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//                whatsappIntent.setType("text/plain");
//                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "https://dream.com");
//                whatsappIntent.setPackage("com.whatsapp");
//
////                startActivity(Intent.createChooser(myIntent, "Поделиться ссылкой через"));
//                Intent chooserIntent = Intent.createChooser(whatsappIntent, "Поделиться через...");
//
//                Intent telegramIntent = null;
//                Intent[] extraIntents = { telegramIntent };
//                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);
//
//                chooserIntent = Intent.createChooser(whatsappIntent, "Поделиться через...");
//
//                extraIntents = new Intent[]{telegramIntent};
//                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);
//
//                try {
//                    startActivity(chooserIntent);
//                } catch (ActivityNotFoundException e) {
//                    makeText(MainActivity.this, "Установите WhatsApp или Telegram", LENGTH_SHORT).show();
//                }
//



        });



//        String[] menu = {"login", "register", "gallery", "notes"};
//
//
//        TextView selection = findViewById(R.id.selection);
//
//        Spinner spinner = findViewById(R.id.spiner_all);
//        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, menu);
//        // Определяем разметку для использования при выборе элемента
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Применяем адаптер к элементу spinner
//        spinner.setAdapter(adapter);
//
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                switch (position) {
//                    case 0:
//                        startActivity(new Intent(MainActivity.this, ActivityLoginStart.class));
//                        break;
//                    case 1:
//                        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
//                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//
//            }
//        };


        Spinner spinner = findViewById(R.id.spiner_all);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.all_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


// выюор меню на главнной из Спинера
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
        switch (position) {
            case 0:
                return;
            //этот будет срабатывать сразу при отображении спиннера
            case 1:
                Intent intent = new Intent(this, ActivityLoginStart.class);
                startActivity(intent);
                return;
            case 2:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return;
            case 3:
                intent = new Intent(this, Gallery.class);
                startActivity(intent);
                return;
            case 4:
                intent = new Intent(this, Activity_zakaz.class);
                startActivity(intent);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}


