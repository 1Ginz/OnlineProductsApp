package com.rajendra.onlineproductsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PayActivity extends AppCompatActivity {

    TextView edit_pay_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        edit_pay_address = findViewById(R.id.edit_pay_address);
        openAddressActivity();
    }

    private void openAddressActivity(){
        edit_pay_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PayActivity.this, AddressActivity.class));
            }
        });
    }

}
