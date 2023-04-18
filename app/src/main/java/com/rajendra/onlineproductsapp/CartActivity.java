package com.rajendra.onlineproductsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlineproductsapp.Helper.ManagementCart;
import com.rajendra.onlineproductsapp.adapter.CartAdapter;
import com.rajendra.onlineproductsapp.adapter.ProductCategoryAdapter;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;


    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    CartAdapter cartAdapter;

//    private ManagementCart

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_cart);


        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));

        setProdItemRecycler(productsList);

    }



    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.cart_recycle);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        cartAdapter = new CartAdapter(this, productsList);
        prodItemRecycler.setAdapter(cartAdapter);

    }

}
