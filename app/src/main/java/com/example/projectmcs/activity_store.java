package com.example.projectmcs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_store extends AppCompatActivity {
    public static ArrayList<productview> viewproduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        viewproduct = new ArrayList<>();

        productview productdata1 = new productview();
        productdata1.id =1;
        productdata1.name="Exploding Kitten";
        productdata1.maxplayer=2;
        productdata1.minplayer=5;
        productdata1.longitude="106.265139";
        productdata1.latitude="-6.912035";
        productdata1.price=250000;

        productview productdata2 = new productview();
        productdata2.id =2;
        productdata2.name="Card Against Humanity";
        productdata2.maxplayer=2;
        productdata2.minplayer=4;
        productdata2.longitude="108.126810";
        productdata2.latitude="-7.586037";
        productdata2.price=182500;

        viewproduct.add(productdata1);
        viewproduct.add(productdata2);



    }
}
