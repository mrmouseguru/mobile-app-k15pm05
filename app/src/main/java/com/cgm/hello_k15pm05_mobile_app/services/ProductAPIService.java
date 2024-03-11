package com.cgm.hello_k15pm05_mobile_app.services;

import com.cgm.hello_k15pm05_mobile_app.entities.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPIService {

    @GET("products")
    Call<List<Product>> getAllProducts();
}
