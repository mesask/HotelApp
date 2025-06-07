package com.example.hotelapp.activity;

import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelapp.data.local.UserSharePreference;

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onResume() {
        super.onResume();
        if(null == UserSharePreference.checkUserLogin(this)){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
