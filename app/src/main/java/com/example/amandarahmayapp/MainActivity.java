package com.example.amandarahmayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_menu);
    }

    public void clickHospital(View view) {
        Intent i = new Intent(this,Hospital.class);
        startActivity(i);
    }
    public void clickPolice(View view){
        Intent i = new Intent(this,Police.class);
        startActivity(i);
    }
    public void clickMarket(View view){
        Intent i = new Intent(this,Market.class);
        startActivity(i);
    }
    public void clickSchool(View view){
        Intent i = new Intent(this,School.class);
        startActivity(i);
    }
}