package com.example.hotelapp.data.remote.api;

import com.example.hotelapp.data.remote.models.response.ProductResponse;
import com.example.hotelapp.data.remote.models.response.ProductsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/products")
//    Call<List<ProductsItem>> getAllProduct();
    Call<ProductResponse> getAllProduct();
}
