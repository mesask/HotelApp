package com.example.hotelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.hotelapp.R;
import com.example.hotelapp.constants.Constants;
import com.example.hotelapp.models.Hotel;

public class HotelDetailActivity extends AppCompatActivity {

    private Hotel hotel;

    private TextView tvHotelNames,tvHotelDescriptions,tvTotalViews,tvTotalShares;

    private ImageView ivHotelImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hotel_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        getDataHotel();
    }

    public void initView(){
        tvHotelDescriptions = findViewById(R.id.tvHotelDescriptions);
        tvHotelNames = findViewById(R.id.tvHotelNames);
        tvTotalViews = findViewById(R.id.tvTotalViews);
        tvTotalShares = findViewById(R.id.tvTotalShares);
        ivHotelImages = findViewById(R.id.ivHotelImages);
    }
    public void getDataHotel(){
        hotel = new Hotel();
        Intent intent = getIntent();
        hotel.setId(intent.getIntExtra(Constants.HOTEL_ID,0));
        hotel.setName(intent.getStringExtra(Constants.HOTEL_NAME));
        hotel.setDescription(intent.getStringExtra(Constants.HOTEL_DESC));
        hotel.setImageUrl(intent.getStringExtra(Constants.HOTEL_IMAGE));
        hotel.setLocation(intent.getStringExtra(Constants.HOTEL_TOTAL_LOCATION));
        hotel.setTotalView(intent.getIntExtra(Constants.HOTEL_TOTAL_VIEW,0));
        hotel.setTotalShare(intent.getIntExtra(Constants.HOTEL_TOTAL_SHARE,0));

        tvHotelNames.setText(hotel.getName());
        tvHotelDescriptions.setText(hotel.getDescription());
        tvTotalViews.setText(""+hotel.getTotalView());
        tvTotalShares.setText(""+hotel.getTotalShare());
        Glide.with(this).load(hotel.getImageUrl()).into(ivHotelImages);

    }
}