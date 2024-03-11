package com.cgm.hello_k15pm05_mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cgm.hello_k15pm05_mobile_app.entities.Product;
import com.cgm.hello_k15pm05_mobile_app.services.ProductAPIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView productListView = findViewById(R.id.productList);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/HelloWebApp/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductAPIService productAPIService =
                retrofit.create(ProductAPIService.class);

        Call<List<Product>> call = productAPIService.getAllProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful()){
                    List<Product> productList = response.body();
                    ArrayAdapter<Product> adapter =
                            new ArrayAdapter<>(MainActivity.this,
                                    android.R.layout.simple_list_item_1, productList);
                    productListView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }
}