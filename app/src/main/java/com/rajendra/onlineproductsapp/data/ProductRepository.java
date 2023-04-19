package com.rajendra.onlineproductsapp.data;

import com.rajendra.onlineproductsapp.R;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Products> getListProductInCart(String userID){
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));
        productsList.add(new Products(3, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(4, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));
        productsList.add(new Products(5, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(6, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));
        return productsList;
    }
}
