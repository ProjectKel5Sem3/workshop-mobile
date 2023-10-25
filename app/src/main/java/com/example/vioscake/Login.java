package com.example.vioscake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private CardView loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        username = findViewById(R.id.emaillogin1);
        password = findViewById(R.id.password1);
        loginButton = findViewById(R.id.buttonlogin1);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("user") &&
                        password.getText().toString().equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Login.this, dashboard.class);
                    startActivity(intent);
                    finish();
                } else if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("1231")) {
                    Toast.makeText(getApplicationContext(), "Login As an Admin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, dashboard.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





