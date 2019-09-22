package com.example.myapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class card_java extends AppCompatActivity {

    DBHandler db;
    Button viewBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_item);

        db = new DBHandler(this);


        viewBtn = (Button)findViewById(R.id.btn_view);

        viewAll();

    }
    public  void viewAll() {
        viewBtn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {


                        Cursor res = db.getAllData();

                        if(res.getCount() == 0){
                            showMessage("Error","No Data Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){

                            buffer.append("vid :"+res.getInt(0)+"\n");
                            buffer.append("phone :"+res.getInt(1)+"\n");
                            buffer.append("price :"+res.getInt(2)+"\n");
                            buffer.append("brand :"+res.getString(3)+"\n");
                            buffer.append("model :"+res.getString(4)+"\n");
                            buffer.append("edition :"+res.getString(5)+"\n");
                            buffer.append("condition :"+res.getString(6)+"\n");
                            buffer.append("transmission :"+res.getString(7)+"\n");
                            buffer.append("fuel :"+res.getString(8)+"\n");
                            buffer.append("engine :"+res.getInt(9)+"\n\n");


                        }
//show data
                        showMessage("Data",buffer.toString());


                    }
                }
        );
    }


    public void showMessage(String title,String message){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
