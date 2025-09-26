package com.example.avtoapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avtoapplication.R;


public class SignUpActivity extends AppCompatActivity {

    private EditText emailSignUp, passwordSingUp, getPasswordConfirmSingUp;
    private Button signUpButton;
    private DataBaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        emailSignUp = findViewById(R.id.sighUpEmail);
        passwordSingUp = findViewById(R.id.signUpPassword);
        getPasswordConfirmSingUp = findViewById(R.id.singUpConfirmPassword);

        signUpButton = findViewById(R.id.signUpButton);

        myDB = new DataBaseHelper(this);
        insertUser();

    }

    private void insertUser() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailSignUp.getText().toString();
                String password = passwordSingUp.getText().toString();
                String confirmPassword = getPasswordConfirmSingUp.getText().toString();

                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirmPassword)) {
                        boolean checkUserEmail = myDB.checkEmail(email);
                        if (!checkUserEmail) {// проверяем email при условий что записи если он пришел из поля заполнения и пароль существует
                            boolean insert = myDB.registerUser(email, password);// делаем новую запись в базе данных
                            if (insert) {
                                Toast.makeText(SignUpActivity.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
                                // очищение поле после регистрации

                                Intent intent = new Intent (SignUpActivity.this,LoginActivity.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(SignUpActivity.this, "Register ERROR", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUpActivity.this, "User already exists.Please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
