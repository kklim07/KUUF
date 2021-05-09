package com.example.projectmcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class activity_product_detail extends AppCompatActivity {
    TextView productname;
    TextView productmin;
    TextView productmax;
    TextView productprice;
    Button buyproductbtn;
    TextView producterrormsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        buyproductbtn = findViewById(R.id.buyproduct);
        productname = findViewById(R.id.productname);
        productmin = findViewById(R.id.productmin);
        productmax = findViewById(R.id.productmax);
        productprice = findViewById(R.id.productprice);
        producterrormsg = findViewById(R.id.producterrortext);

    }
}
