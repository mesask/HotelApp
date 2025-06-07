package com.example.hotelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hotelapp.R;
import com.example.hotelapp.constants.Constants;
import com.example.hotelapp.data.local.UserSharePreference;
import com.example.hotelapp.models.User;
import com.example.hotelapp.utils.MessageUtils;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;

    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imageViewww), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 👉 This line is missing!
        initView();  // Call your method to initialize views and button click
    }

    private void initView(){
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(username.isEmpty()){
            //Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show();
            MessageUtils.showToastMessage(this,"Please enter your name");
        }else if(password.isEmpty()){
            //Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show();
            MessageUtils.showToastMessage(this,"Please enter your password");
            //return;
        }else if(!Constants.USER_NAME_DATA.equals(username) || !Constants.USER_PASSWORD_DATA.equals(password)){
            //Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show();
            MessageUtils.showToastMessage(this,"Login credential incorrect");
            //return;
        }else{
            User user = new User();
            user.setId(1);
            user.setUsername(username);
            user.setPassword(password);
            user.setAccessToken(UUID.randomUUID().toString());
            UserSharePreference.saveUserData(this, user);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            // Save local storage
            //UserSharePreference.saveUserData(this, user);
        }

    }
}