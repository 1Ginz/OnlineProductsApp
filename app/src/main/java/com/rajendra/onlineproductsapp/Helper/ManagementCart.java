package com.rajendra.onlineproductsapp.Helper;

import android.content.Context;

import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertItem(Products item){
        ArrayList<Products> listItem = getListCart();
        boolean existAlready = false;
        int n = 0;
        for(int i =0; i < listItem.size(); i++){
            if(listItem.get(i).getProductid().equals(item.getProductid())){
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready == true){
//            listItem.get(n).set
        }
    }

    public ArrayList<Products> getListCart(){
        return tinyDB.getListObject("CartList");
    }
}
