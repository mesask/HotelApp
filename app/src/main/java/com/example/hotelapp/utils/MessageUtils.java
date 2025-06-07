package com.example.hotelapp.utils;

import android.content.Context;
import android.widget.Toast;

public class MessageUtils {
    public static void showToastMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
