package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        Window w = getWindow();
        w.setFlags( WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        RecyclerView recyclerView = findViewById(R.id.rv_list);

        List<item> mList = new ArrayList<>();


        mList.add(new item(R.drawable.img1,"Anuka",R.drawable.profile1));
        mList.add(new item(R.drawable.img2,"Miyuru",R.drawable.profile2));
        mList.add(new item(R.drawable.img3,"Amasha",R.drawable.profile3));

        Adapter adapter = new Adapter(this,mList);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }




}
