package com.example.hotelapp.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.R;
import com.example.hotelapp.adapter.HotelAdapter;
import com.example.hotelapp.models.Hotel;

import java.util.ArrayList;
import java.util.List;

public class DemoRecycleViewActivity extends BaseActivity {
    private List<Hotel> hotelList;
    private HotelAdapter hotelAdapter;
    private RecyclerView recyclerViewHotel;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo_recycle_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerViewHotel = findViewById(R.id.rcHotel);
        // Grid View or List View
        layoutManager = new LinearLayoutManager(this);
        recyclerViewHotel.setLayoutManager(layoutManager);
        // Get all data to list
        getData();
        // New Adapter Set Data
        hotelAdapter = new HotelAdapter(this, hotelList);
        // set Adapter to Recycler View
        recyclerViewHotel.setAdapter(hotelAdapter);

    }

    private void getData(){
        hotelList = new ArrayList<>();
        Hotel koshaHotel = new Hotel();
        koshaHotel.setId(0);
        koshaHotel.setName("Sokha Hotel");
        koshaHotel.setDescription("Sokha Hotel in Phnom Penh");
        koshaHotel.setLocation("Phnom Penh");
        koshaHotel.setTotalView(200);
        koshaHotel.setTotalShare(2800);
        koshaHotel.setImageUrl("https://sokhahotels.com.kh/img/hotels/Swimming-pool-1.jpg");
        hotelList.add(koshaHotel);

        Hotel koshaHotelIPS = new Hotel();
        koshaHotelIPS.setId(0);
        koshaHotelIPS.setName("Sokha Hotel");
        koshaHotelIPS.setDescription("Sokha Hotel in Phnom Penh");
        koshaHotelIPS.setLocation("Poi Pet");
        koshaHotelIPS.setTotalView(200);
        koshaHotelIPS.setTotalShare(2800);
        koshaHotelIPS.setImageUrl("https://sokhahotels.com.kh/img/hotels/lbp.jpg");
        hotelList.add(koshaHotelIPS);

        Hotel koshaHotelKPC = new Hotel();
        koshaHotelKPC.setId(0);
        koshaHotelKPC.setName("Sokha Hotel");
        koshaHotelKPC.setDescription("Sokha Hotel in Phnom Penh");
        koshaHotelKPC.setLocation("Siem Reap");
        koshaHotelKPC.setTotalView(200);
        koshaHotelKPC.setTotalShare(2800);
        koshaHotelKPC.setImageUrl("https://sokhahotels.com.kh/img/dinning/sushi.jpg");
        hotelList.add(koshaHotelKPC);

    }
}