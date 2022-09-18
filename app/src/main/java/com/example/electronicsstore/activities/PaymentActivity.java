package com.example.electronicsstore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.electronicsstore.R;
import com.example.electronicsstore.models.NewProductsModel;
import com.example.electronicsstore.models.PopularProductModel;
import com.example.electronicsstore.models.ShowAllModel;

public class PaymentActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView total;
    Button checkOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Object obj = getIntent().getSerializableExtra("item");

        toolbar = findViewById(R.id.payment_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        total = findViewById(R.id.total_amt);
        checkOutBtn = findViewById(R.id.pay_btn);

        double amount = 0.0;
        if(obj instanceof NewProductsModel) {
            NewProductsModel newProductsModel = (NewProductsModel) obj;
            amount = newProductsModel.getPrice();
        }
        if(obj instanceof PopularProductModel) {
            PopularProductModel popularProductModel = (PopularProductModel) obj;
            amount = popularProductModel.getPrice();
        }
        if(obj instanceof ShowAllModel) {
            ShowAllModel showAllModel = (ShowAllModel) obj;
            amount = showAllModel.getPrice();
        }

        total.setText(amount + " tenge");
        
        checkOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this, "Payment Done Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaymentActivity.this, MainActivity.class));
            }
        });
    }
}