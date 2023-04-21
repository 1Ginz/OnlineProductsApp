package com.rajendra.onlineproductsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlineproductsapp.Helper.ManagementCart;
import com.rajendra.onlineproductsapp.adapter.CartAdapter;
import com.rajendra.onlineproductsapp.adapter.ProductCategoryAdapter;
import com.rajendra.onlineproductsapp.data.ProductRepository;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;

    TextView continuetopayment;


    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    CartAdapter cartAdapter;

//    private ManagementCart

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_cart);

        continuetopayment = findViewById(R.id.continuetopayment);
        openPayActivity();

        List<Products> productsList = new ProductRepository().getListProductInCart(null);
        setProdItemRecycler(productsList);



    }



    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.cart_recycle);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(this, productsList);
        prodItemRecycler.setAdapter(cartAdapter);

    }

    private void openPayActivity(){
        continuetopayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, PayActivity.class));
            }
        });
    }

}
