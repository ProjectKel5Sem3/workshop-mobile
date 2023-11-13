package com.example.vioscake.EntryPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vioscake.Home;
import com.example.vioscake.NavbarFragment;
import com.example.vioscake.R;

public class Login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private CardView loginButton;
    private TextView signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

            username = findViewById(R.id.emaillogin1);
            password = findViewById(R.id.password1);
            loginButton = findViewById(R.id.buttonlogin1);
            signupButton = findViewById(R.id.signuptext1);


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (username.getText().toString().equals("user") &&
                            password.getText().toString().equals("1234")) {
                        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, NavbarFragment.class);
                        startActivity(intent);
                        finish();
                    } else if (username.getText().toString().equals("admin") &&
                            password.getText().toString().equals("1231")){
                        Toast.makeText(getApplicationContext(), "Login sebagai Admin", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, NavbarFragment.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            signupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, Register.class);
                    startActivity(intent);
                }
            });
        }
    }

