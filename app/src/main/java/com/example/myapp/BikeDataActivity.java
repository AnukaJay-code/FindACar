package com.example.myapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BikeDataActivity extends AppCompatActivity {


    private static final String Tag = "BikeDataActivity";
    DBHandler mDBHandler;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_list);

        mListView = (ListView) findViewById(R.id.listView);
        mDBHandler = new DBHandler(this);


        populateListView();

    }





    private void populateListView() {

        Cursor data = mDBHandler.getBikeData();
        ArrayList<String> listData = new ArrayList<>();



        while(data.moveToNext()){
            listData.add("Brand   : "+data.getString(3)+"\nModel   : "+data.getString(4)+"\nEdition : "+data.getString(5)+"\nPrice   : "+data.getString(2));
            // listData.add("Price : "+data.getString(2));
            // listData.add("Model : "+data.getString(4));

        }



        final ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Object object = adapterView.getItemAtPosition(i);

                Cursor data1 = mDBHandler.getBikeData();
                data1.moveToPosition(i);

                String type = "bike";
                int vid = data1.getInt(0);
                int phone = data1.getInt(1);
                int price = data1.getInt(2);
                String brand  =  data1.getString(3);
                String model  =  data1.getString(4);
                String edition  =  data1.getString(5);
                String condition  =  data1.getString(6);
                String transmission  =  data1.getString(7);
                String fuel  =  data1.getString(8);
                int engine = data1.getInt(9);


                Intent editScreenIntent = new Intent(BikeDataActivity.this,EditDataActivity.class);
                editScreenIntent.putExtra("type",type);
                editScreenIntent.putExtra("vid",vid);
                editScreenIntent.putExtra("phone",phone);
                editScreenIntent.putExtra("price",price);
                editScreenIntent.putExtra("brand",brand);
                editScreenIntent.putExtra("model",model);
                editScreenIntent.putExtra("edition",edition);
                editScreenIntent.putExtra("condition",condition);
                editScreenIntent.putExtra("transmission",transmission);
                editScreenIntent.putExtra("fuel",fuel);
                editScreenIntent.putExtra("engine",engine);

                startActivity(editScreenIntent);

                /*

            data1 = mDBHandler.getItemID(vid);

            int itemID = -1;

            while(data1.moveToNext()){
                itemID = data1.getInt(0);
            }

            if(itemID > -1){
                Toast.makeText(ListDataActivity.this,"Got data",Toast.LENGTH_LONG).show();
                Intent editScreenIntent = new Intent(ListDataActivity.this,EditDataActivity.class);
                editScreenIntent.putExtra("vid",vid);
                startActivity(editScreenIntent);
            }
            else{

                Toast.makeText(ListDataActivity.this,"No associate ID with that VID",Toast.LENGTH_LONG).show();


            }
            */

            }
        });

    }
}
