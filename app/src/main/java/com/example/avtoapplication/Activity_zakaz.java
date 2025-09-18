package com.example.avtoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avtoapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity_zakaz extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView contactRv;

    private DBHelper dbhelper;

    private AdapterContact adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakaz);

        dbhelper = new DBHelper(this);// инициализациия баззы данных dbhelper



        fab = findViewById(R.id.fab);

        contactRv = findViewById(R.id.contactRv);

        contactRv.setHasFixedSize(true); // фиксируем стандарстный размер каждого элемента






        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_zakaz.this, AddEditContact.class);
                startActivity(intent);
            }
        });
    loadData();
    }

    private void loadData(){

        adapterContact = new AdapterContact(this,dbhelper.getAllData());
            contactRv.setAdapter(adapterContact);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}