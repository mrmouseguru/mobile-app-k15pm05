package com.cgm.hello_k15pm05_mobile_app.services;

import com.cgm.hello_k15pm05_mobile_app.entities.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAPIClient {
    private static final String URL = "http://localhost:8080/HelloWebApp/rest/products";
    public ProductAPIService productAPIService;

    public ProductAPIClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productAPIService = retrofit.create(ProductAPIService.class);
    }


}
