package com.example.hotelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapp.R;
import com.example.hotelapp.adapter.HotelAdapter;
import com.example.hotelapp.constants.Constants;
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
        layoutManager = new GridLayoutManager(this,1);
        recyclerViewHotel.setLayoutManager(layoutManager);
        // Get all data to list
        getData();
        // New Adapter Set Data
        hotelAdapter = new HotelAdapter(this, hotelList, new HotelAdapter.OnClickListener() {
            @Override
            public void onClickView(View view, Hotel data) {
//                Intent intent = new Intent()
                openHotelDetail(data);
            }
        });
        // set Adapter to Recycler View
        recyclerViewHotel.setAdapter(hotelAdapter);

    }

    private void openHotelDetail(Hotel data){
        Intent intent = new Intent(this, HotelDetailActivity.class);
//        Intent intent = new Intent(this, HotelDetailActivity.)
        intent.putExtra(Constants.HOTEL_ID,data.getId());
        intent.putExtra(Constants.HOTEL_NAME,data.getName());
        intent.putExtra(Constants.HOTEL_IMAGE,data.getImageUrl());
        intent.putExtra(Constants.HOTEL_DESC,data.getDescription());
        intent.putExtra(Constants.HOTEL_TOTAL_LOCATION,data.getLocation());
        intent.putExtra(Constants.HOTEL_TOTAL_VIEW,data.getTotalView());
        intent.putExtra(Constants.HOTEL_TOTAL_SHARE,data.getTotalShare());
        startActivity(intent);


    }

    private void getData(){
        hotelList = new ArrayList<>();
        Hotel koshaHotel = new Hotel();
        koshaHotel.setId(0);
        koshaHotel.setName("Sokha Hotel");
//        koshaHotel.setDescription("Sokha Hotel in Phnom Penh");
        koshaHotel.setDescription("-Password Log in After Setup : 1234 .\n" +
                "\n" +
                "-Goods are sold no refund and return.\n" +
                "\n" +
                "-Warranty covers parts according to the specified period.\n" +
                "\n" +
                "-Extra Free Item Are not Warranty.\n" +
                "\n" +
                "-No Warranty On Adapter/Lost/Broken/Damage/Water-Damage or Missing Warranty Seal.\n" +
                "\n" +
                "-ASUS/MSI Cambodia Products are warranted according to the company's terms and conditions.\n" +
                "\n" +
                "-For Apple devices with iCloud lock the warranty return will be voided.\n" +
                "\n" +
                "-Gaming Laptop (GPU) Not Warranty on Screen and Adapter.\n" +
                "\n" +
                "-Warranty processing time in case of issues can range from 2 to 6 weeks.\n" +
                "\n" +
                "-VAT is not include in this invoice / Can not be used for Tax Declaration.Create new documents or edit existing files - Share documents and collaborate in the same document at the same time. - Work anywhere, anytime - even offlineCreate new documents or edit existing files - Share documents and collaborate in the same document at the same time. - Work anywhere, anytime - even offlineCreate new documents or edit existing files - Share documents and collaborate in the same document at the same time. - Work anywhere, anytime - even offlineCreate new documents or edit existing files - Share documents and collaborate in the same document at the same time. - Work anywhere, anytime - even offline");
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