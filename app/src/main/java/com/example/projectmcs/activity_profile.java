package com.example.projectmcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class activity_profile extends AppCompatActivity {

    Button buttonpay;
    RadioButton tr250;
    RadioButton tr500;
    RadioButton tr1000;
    EditText passedittext;
    TextView passhelptext;
    TextView errormsg;
    String pass;
    int nominaltr;
    TextView profusername;
    TextView profgender;
    TextView profphone;
    TextView profmoney;
    TextView profdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        buttonpay = findViewById(R.id.profilepaybtn);
        tr250 = findViewById(R.id.Radio250);
        tr500 = findViewById(R.id.Radio500);
        tr1000 = findViewById(R.id.Radio1000);
        passedittext = findViewById(R.id.edittextprofilepass);
        passhelptext = findViewById(R.id.passhelper);
        errormsg = findViewById(R.id.textprofileerror);
        profusername = findViewById(R.id.profusername);
        profgender = findViewById(R.id.profgender);
        profphone = findViewById(R.id.profphonenum);
        profmoney = findViewById(R.id.profmoney);
        profdate = findViewById(R.id.profbirth);

        buttonpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = passedittext.getText().toString();
                if(validatePrice()){
                    OpenActivity_Login();
                }
            }
        });
    }

    private void OpenActivity_Login() {
    }

    private Boolean validatePrice(){
        if(tr250.isChecked()){
            nominaltr = 250000;
        }
        if(tr500.isChecked()){
            nominaltr = 500000;
        }
        if(tr1000.isChecked()){
            nominaltr = 1000000;
        }
        if(!(tr250.isChecked() || tr500.isChecked()) || tr1000.isChecked()){
            errormsg.setText("Nominal must be selected");
            return false;
        }
        else {
            errormsg.setText(null);
            return true;
        }
    }
}
