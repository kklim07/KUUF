package com.example.projectmcs;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    TextView error;
    Button gohome;
    Button goregister;
    String txtusername;
    String txtpassword;
    Data datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.textviewusernamelogin);
        password = findViewById(R.id.textviewpasswordlogin);
        error = findViewById(R.id.txterrormessage);
        gohome = findViewById(R.id.btnlogin);
        goregister = findViewById(R.id.btnregister);




        goregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivityRegister();
            }
        });



        gohome.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                txtusername = username.getText().toString();
                txtpassword = password.getText().toString();
                if (validateUsername() && validatePassword() && validateid()) {
                    OpenActivityLogin();
                }
            }
        });
    }

    private void OpenActivityLogin() {
        Intent intent = new Intent(this, activity_home.class);
        startActivity(intent);
    }

    private void OpenActivityRegister() {
        Intent intent = new Intent(this, activity_register.class);
        startActivity(intent);
    }


    private Boolean validateUsername(){
        if(txtusername.isEmpty()){
            error.setText("Username must be filled");
            return false;
        }
        else {
            error.setText(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        if(txtpassword.isEmpty()){
            error.setText("Password must be filled");
            return false;
        }
        else {
            error.setText(null);
            return true;
        }
    }
    private Boolean validateid(){
//        for(int i = 0; i >= datalist; i++){
//
//        }
        if(datalist.username.equals(txtusername) && datalist.password.equals(txtpassword)){
            error.setText(null);
            return true;
        }
        else {
            error.setText("Please gave the right answer and password combination");
            return false;
        }
    }
}
