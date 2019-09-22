package com.example.myapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListDataActivity extends AppCompatActivity {

    private static final String Tag = "ListDataActivity";
    DBHandler mDBHandler;
   // private ListView mListView;
   SwipeMenuListView mListView;
    EditText filter;
    private ArrayAdapter adapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

       // mListView = (ListView) findViewById(R.id.listView);
        mDBHandler = new DBHandler(this);
        filter = (EditText)findViewById(R.id.searchFilter);
        mListView = (SwipeMenuListView) findViewById(R.id.listView);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {

                // create "call" item
                SwipeMenuItem call = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                call.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                call.setWidth(250);
                // set a icon
                call.setIcon(R.drawable.ic_phone);

                // add to menu
                menu.addMenuItem(call);
            }
        };

        mListView.setMenuCreator(creator);

        populateListView();



    }





    private void populateListView() {

        Cursor data = mDBHandler.getAllData();
        ArrayList<String> listData = new ArrayList<>();



        while(data.moveToNext()){
            listData.add("Brand   : "+data.getString(3)+"\nModel   : "+data.getString(4)+"\nEdition : "+data.getString(5)+"\nPrice   : "+data.getString(2));


        }



        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (ListDataActivity.this).adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {


                Cursor data1 = mDBHandler.getAllData();
                data1.moveToPosition(position);

                int phone = data1.getInt(1);

                Uri u = Uri.parse("tel:" + phone);

                Intent i = new Intent(Intent.ACTION_DIAL,u);
                try
                {
                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    startActivity(i);
                }
                catch (SecurityException s)
                {
                    // show() method display the toast with
                    // exception message.
                    Toast.makeText(ListDataActivity.this, "Failed to open dialer", Toast.LENGTH_LONG).show();
                }

                return false;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Object object = adapterView.getItemAtPosition(i);

                Cursor data1 = mDBHandler.getAllData();
                data1.moveToPosition(i);

                String type = "car";
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


                Intent editScreenIntent = new Intent(ListDataActivity.this,EditDataActivity.class);
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
