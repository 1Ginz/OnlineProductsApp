package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rajendra.onlineproductsapp.model.Products;

public class Productdetails extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView titleTxt,feeTxt, descriptionTxt, numberOderTxt;
    private ImageView plusBtn, minusBtn, imageProduct, backBtn;

    private Products object;
    int numberOder = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);

        initView();
//        getBundle();

    }

    private void getBundle(){
        object = (Products) getIntent().getSerializableExtra("object");

//        int drawableResourceId = this.getResources().getIdentifier(object.getImageUrl(),"drawable",this.getPackageName());
//        Glide.with(this)
//                .load(drawableResourceId)
//                .into(imageProduct);
        titleTxt.setText(object.getProductName());
        feeTxt.setText("₫"+object.getProductPrice());
        descriptionTxt.setText(object.getProductQty());
        numberOderTxt.setText(String.valueOf(numberOder));

        plusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberOder = numberOder + 1;
                numberOderTxt.setText(String.valueOf(numberOder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(numberOder>1){
                    numberOder -= 1;
                }
                numberOderTxt.setText(String.valueOf(numberOder));
            }
        });
    }


    private void initView(){
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.feeTxt);
        descriptionTxt = findViewById(R.id.feeTxt);
        numberOderTxt = findViewById(R.id.numberOderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        imageProduct = findViewById(R.id.imageProduct);
        backBtn = findViewById(R.id.backBtn);

        plusBtn.setOnClickListener((e) -> {
            numberOderTxt.setText(String.valueOf(Integer.valueOf((String) numberOderTxt.getText()) + 1));
        });

        minusBtn.setOnClickListener((e) -> {
            numberOderTxt.setText(String.valueOf(Math.max(1, Integer.valueOf((String) numberOderTxt.getText()) - 1)));
        });

        addToCartBtn.setOnClickListener((e) -> {
            Intent i = new Intent(this.getApplicationContext(), CartActivity.class);
            i.putExtra("DATA", object);
            startActivity(i);
        });
    }

}
