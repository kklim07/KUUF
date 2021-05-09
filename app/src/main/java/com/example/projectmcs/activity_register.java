package com.example.projectmcs;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_register extends AppCompatActivity {

    TextView regusername;
    TextView regpassword;
    TextView phonenum;
    TextView repassword;
    DatePicker datebirth;
    RadioButton radiomale;
    RadioButton radiofemale;
    CheckBox checkagree;
    TextView errormsgs;
    Button regbutton;
    String txtusername;
    String txtpassword;
    String txtphonenum;
    String txtrepassword;
    String gender;

    public static ArrayList<Data> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regusername = findViewById(R.id.textviewusername);
        regpassword = findViewById(R.id.textviewpassword);
        phonenum = findViewById(R.id.textviewphone);
        repassword = findViewById(R.id.textviewrepassword);
        datebirth = findViewById(R.id.datebirth);
        radiomale = findViewById(R.id.RadioMale);
        radiofemale = findViewById(R.id.RadioFemale);
        checkagree = findViewById(R.id.checkboxagreement);
        errormsgs = findViewById(R.id.texterrors);
        regbutton = findViewById(R.id.regbtnreg);

        phonenum.setInputType(InputType.TYPE_CLASS_NUMBER);



        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtusername = regusername.getText().toString();
                txtpassword = regpassword.getText().toString();
                txtphonenum = phonenum.getText().toString();
                txtrepassword = repassword.getText().toString();
                if(validateUsername() && validatePassword() && validatePhonenum() && validateRepassword() && validateDatebirth() && validateGender() &&  validateAgreement()){
                    datalist = new ArrayList<>();
                    Data data1 = new Data();
                    data1.username=txtusername;
                    data1.password=txtpassword;
                    data1.date=datebirth.toString();
                    data1.gender=gender;
                    data1.phonenum=txtphonenum;
                    data1.money=0;
                    datalist.add(data1);
                    OpenActivity_Login();
                }
            }
        });

    }

    private void OpenActivity_Login() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private Boolean validateUsername(){
        if(txtusername.isEmpty()){
            errormsgs.setText("Username must be filled");
            return false;
        }
        else if(txtusername.length()<6 | txtusername.length()>12 ) {
            errormsgs.setText("Username must be between 6 and 12 characters");
            return false;
        }
        else {
            errormsgs.setText(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        if(txtpassword.isEmpty()){
            errormsgs.setText("Password must be filled");
            return false;
        }
        else if(txtpassword.length()<8) {
            errormsgs.setText("Password must be more than 8 characters");
            return false;
        }
        else if(!(txtpassword.contains("1") || txtpassword.contains("2") || txtpassword.contains("3") || txtpassword.contains("4") || txtpassword.contains("5") ||txtpassword.contains("6") ||txtpassword.contains("7") ||txtpassword.contains("8") ||txtpassword.contains("9") ||txtpassword.contains("0"))) {
            errormsgs.setText("Password must be alphanumeric");
            return false;
        }
        else {
            errormsgs.setText(null);
            return true;
        }
    }

    private Boolean validatePhonenum(){
        if(txtphonenum.isEmpty()){
            errormsgs.setText("Phone number must be filled");
            return false;
        }
        else if(txtphonenum.length()<10 ||txtphonenum.length()>12) {
            errormsgs.setText("Phone number must be between 10 and 12 digits");
            return false;
        }
        else {
            errormsgs.setText(null);
            return true;
        }
    }

    private Boolean validateRepassword(){
        if(txtrepassword.isEmpty()){
            errormsgs.setText("Confirmation password must be filled");
            return false;
        }
        else if(!txtrepassword.equals(txtpassword)) {
            errormsgs.setText("Confirmation password must be the same with password");
            return false;
        }
        else {
            errormsgs.setText(null);
            return true;
        }
    }

    private Boolean validateDatebirth(){

        if(!datebirth.isEnabled()){
            errormsgs.setText("Date of birth must be chosen");
            return false;
        }
        else {
            errormsgs.setText(null);
            return true;
        }
    }

    private Boolean validateGender(){
        if(radiomale.isChecked()){
            gender="Male";
        }
        if(radiofemale.isChecked()){
            gender="Female";
        }
        if(!(radiomale.isChecked() || radiofemale.isChecked())){
            errormsgs.setText("Gender must be selected");
            return false;
        }
        else {
            errormsgs.setText(null);
            return true;
        }
    }

    private Boolean validateAgreement(){
        if(!checkagree.isChecked()){
            errormsgs.setText("Agreement must be selected");
            return false;
        }
        else {
            errormsgs.setText(null);
            return true;
        }
    }
}
