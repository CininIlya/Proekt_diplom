package com.example.avtoapplication.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avtoapplication.Activity_zakaz;
import com.example.avtoapplication.AddEditContact;
import com.example.avtoapplication.R;


public class LoginActivity extends AppCompatActivity {


        private EditText loginEmail, loginPassword;
        private Button loginButton;

        private com.example.avtoapplication.login.DataBaseHelper myDB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            loginEmail = findViewById(R.id.LoginEmail);
            loginPassword = findViewById(R.id.loginPassword);
            loginButton = findViewById(R.id.loginbutton);

            myDB = new com.example.avtoapplication.login.DataBaseHelper(this);
            loginUser();

        }

        private void loginUser() {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = loginEmail.getText().toString();
                    String password = loginPassword.getText().toString();
                    boolean log = myDB.checkUser(email, password);

                    if (email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "All fields are  mandory", Toast.LENGTH_SHORT).show();
                    } else {
                        if (log) {
                            Toast.makeText(LoginActivity.this, "Login Succefilly", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, Activity_zakaz.class); // переход в базу заказов
                            startActivity(intent);

                        } else {
                            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }

