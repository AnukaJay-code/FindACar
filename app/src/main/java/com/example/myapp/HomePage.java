package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //Toast.makeText(HomePage.this," on Create homepage",Toast.LENGTH_LONG).show();

    }

    public void onClickCar(View view){

        Intent intent = new Intent(this,ListDataActivity.class);
        startActivity(intent);
    }

    public void onClickJeep(View view){

        Intent intent = new Intent(this,JeepDataActivity.class);
        startActivity(intent);
    }

    public void onClickBike(View view){

        Intent intent = new Intent(this,BikeDataActivity.class);
        startActivity(intent);
    }


    public void onClickplus(View view){

        Intent intent = new Intent(this,Vehicle_form.class);
        startActivity(intent);
    }




}
