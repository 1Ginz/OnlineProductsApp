package com.rajendra.onlineproductsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlineproductsapp.Productdetails;
import com.rajendra.onlineproductsapp.R;
import com.rajendra.onlineproductsapp.model.Cart;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ProductViewHolder> {
    Context context;
    List<Products> productsList;

    public CartAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public CartAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_cart, parent, false);
        return new CartAdapter.ProductViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.ProductViewHolder holder, int position) {
        System.out.println("ZOOOZOZOZOOZ: " + productsList.size());
        holder.prodImage.setImageResource(productsList.get(position).getImageUrl());
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.prodQty.setText(productsList.get(position).getProductQty());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());
        holder.productIDTextView.setText(productsList.get(position).getProductid().toString());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Productdetails.class);
/*
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
               */
                context.startActivity(i/*, activityOptions.toBundle()*/);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public static final class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView prodImage;
        TextView prodName, prodQty, prodPrice;
        ImageView plusBtn, minusBtn;
        TextView numberOfProductTextView;
        TextView productIDTextView;

        public ProductViewHolder(@NonNull View itemView, CartAdapter cartAdapter) {
            super(itemView);

            productIDTextView = itemView.findViewById(R.id.productIDTextView);
            prodImage = itemView.findViewById(R.id.cart_img);
            prodName = itemView.findViewById(R.id.cart_name);
            prodPrice = itemView.findViewById(R.id.productPrice);
            prodQty = itemView.findViewById(R.id.priceOfMultipleProduct);
            plusBtn = itemView.findViewById(R.id.plusBtnInCart);
            minusBtn = itemView.findViewById(R.id.minusBtnInCart);
            numberOfProductTextView = itemView.findViewById(R.id.numberOfProduct);
            plusBtn.setOnClickListener((e) -> {
                numberOfProductTextView.setText(String.valueOf(Integer.valueOf((String) numberOfProductTextView.getText()) + 1));
            });

            minusBtn.setOnClickListener((e) -> {
                int value = Integer.valueOf((String) numberOfProductTextView.getText()) - 1;
                if (value == 0) {
                    int pid = Integer.parseInt((String) productIDTextView.getText());
                    for (int i = 0; i < cartAdapter.getItemCount(); i++) {
                        if(cartAdapter.productsList.get(i).getProductid() == pid){
                            cartAdapter.productsList.remove(i);
                            cartAdapter.notifyItemRemoved(i);
                            break;
                        }
                    }
                } else {
                    numberOfProductTextView.setText(String.valueOf(value));
                }
            });
        }
    }

}
