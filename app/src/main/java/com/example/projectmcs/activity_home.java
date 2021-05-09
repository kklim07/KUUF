package com.example.projectmcs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class activity_home extends AppCompatActivity {

    ListView listview;
    public static ArrayList<list_view> itemlist;
    RecyclerView rvitem;
    DataAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        Intent intent = null;
        switch (item.getItemId()){
            case R.id.menuhome:
                intent = new Intent(this, activity_home.class);
                break;
            case R.id.menustore:
                intent = new Intent(this, activity_store.class);
                break;
            case R.id.menuprofile:
                intent = new Intent(this, activity_profile.class);
                break;
            case R.id.menulogout:
                intent = new Intent(this, MainActivity.class);
                recreate();
                break;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        itemlist = new ArrayList<>();

        list_view itemdata1 = new list_view();
        itemdata1.name="Exploding Kitten";
        itemdata1.price=250000;

        list_view itemdata2 = new list_view();
        itemdata2.name="Card Against Humanity";
        itemdata2.price=182500;

        itemlist.add(itemdata1);
        itemlist.add(itemdata2);

        rvitem = findViewById(R.id.rvitem);
        LinearLayoutManager llmanager = new LinearLayoutManager(this);
        rvitem. setLayoutManager(llmanager);

        adapter =  new DataAdapter(this,itemlist);
        rvitem.setAdapter(adapter);
    }
}
