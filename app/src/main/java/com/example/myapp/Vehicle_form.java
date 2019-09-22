package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telecom.InCallService;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Vehicle_form extends AppCompatActivity {

    DBHandler db;
    String regexStr = "^[0-9]{10}$";
    EditText price,brand,model,edition,engine,phone;
    Button addButton,viewBtn;
    RadioButton condition,transmission,fuel,type,brandNew,auto,petrol;
    RadioGroup groupCondition,groupTransmission,groupFuel,groupType;
    boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_form);

        Intent intent = getIntent();

        db = new DBHandler(this);

        phone = (EditText)findViewById(R.id.phone);
        price = (EditText)findViewById(R.id.price);
        brand = (EditText)findViewById(R.id.brand);
        model = (EditText)findViewById(R.id.model);
        edition = (EditText)findViewById(R.id.edition);
        engine = (EditText)findViewById(R.id.engine);
        groupCondition = (RadioGroup) findViewById(R.id.condition);
        groupTransmission = (RadioGroup) findViewById(R.id.transmssion);
        groupFuel = (RadioGroup) findViewById(R.id.fuel);
        groupType = (RadioGroup) findViewById(R.id.type);
        brandNew = (RadioButton)findViewById(R.id.brandnew);
        auto = (RadioButton)findViewById(R.id.auto);
        petrol = (RadioButton)findViewById(R.id.petrol);


        addButton = (Button)findViewById(R.id.addBtn);



        AddData();


    }



public  void AddData() {
    addButton.setOnClickListener(
            new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(groupType.getCheckedRadioButtonId() == -1){
                        Toast.makeText(getApplicationContext(),"Please Select Vehicle Type",Toast.LENGTH_LONG).show();
                    } else if(phone.getText().toString().length() == 0 ) {
                        phone.setError( "Please Enter Phone Number!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(!phone.getText().toString().matches(regexStr) ) {
                        phone.setError( "Please Enter Phone Number!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(price.getText().toString().isEmpty() || price.getText().toString() ==  "0" ){
                        price.setError( "Please Enter Vehicle Price!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(brand.getText().toString().isEmpty()){
                        brand.setError( "Please Enter Vehicle Brand!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(model.getText().toString().isEmpty()){
                        model.setError( "Please Enter Vehicle Model!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(edition.getText().toString().isEmpty()){
                        edition.setError( "Please Enter Vehicle Edition!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(groupCondition.getCheckedRadioButtonId() == -1){
                        brandNew.setError( "Please Select Vehicle Condition!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(groupTransmission.getCheckedRadioButtonId() == -1){
                        auto.setError( "Please Select Vehicle Transmission!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(groupFuel.getCheckedRadioButtonId() == -1){
                        petrol.setError( "Please Select Vehicle Fuel Type!" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }else if(engine.getText().toString().isEmpty() || Integer.parseInt(engine.getText().toString()) > 10000){
                        engine.setError( "Please Enter Vehicle Engine Capacity!(max=10000)" );
                        Toast.makeText(getApplicationContext(),"Failed to post Advertisement",Toast.LENGTH_SHORT).show();
                    }
                    else {

                        int conditionId = groupCondition.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        condition = (RadioButton) findViewById(conditionId);

                        int transmissionId = groupTransmission.getCheckedRadioButtonId();
                        // find the radiobutton by returned id
                        transmission = (RadioButton) findViewById(transmissionId);

                        int fuelId = groupFuel.getCheckedRadioButtonId();
                        // find the radiobutton by returned id
                        fuel = (RadioButton) findViewById(fuelId);

                        int typeId = groupType.getCheckedRadioButtonId();
                        // find the radiobutton by returned id
                        type = (RadioButton) findViewById(typeId);

                        String typeV = type.getText().toString();

                        if (typeV.equals("Car")) {
                            result = db.addData(Integer.parseInt(phone.getText().toString()), Integer.parseInt(price.getText().toString()), brand.getText().toString(), model.getText().toString(), edition.getText().toString(), condition.getText().toString(), transmission.getText().toString(), fuel.getText().toString(), Integer.parseInt(engine.getText().toString()));
                        } else if (typeV.equals("Jeep")) {
                            result = db.addJeep(Integer.parseInt(phone.getText().toString()), Integer.parseInt(price.getText().toString()), brand.getText().toString(), model.getText().toString(), edition.getText().toString(), condition.getText().toString(), transmission.getText().toString(), fuel.getText().toString(), Integer.parseInt(engine.getText().toString()));

                        } else {
                            result = db.addBike(Integer.parseInt(phone.getText().toString()), Integer.parseInt(price.getText().toString()), brand.getText().toString(), model.getText().toString(), edition.getText().toString(), condition.getText().toString(), transmission.getText().toString(), fuel.getText().toString(), Integer.parseInt(engine.getText().toString()));

                        }


                        if (result == true) {
                            Toast.makeText(Vehicle_form.this, "Data inserted Successfully", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(Vehicle_form.this, "Data failed to insert", Toast.LENGTH_LONG).show();
                        }


                    }
                }
            }
    );
}




/*
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



*/
                }


/*
    public void AddData() {

        addButton.setOnClickListener(
                new View.OnClickListener() {


                    public void onClick(View view) {

                        String phonen = phone.getText().toString();
                        int phonex = Integer.parseInt(phonen);

                        String pricen = price.getText().toString();
                        int pricex = Integer.parseInt(pricen);

                        String enginen = engine.getText().toString();
                        int enginex = Integer.parseInt(enginen);


                        boolean result = db.addData(phonex, pricex, brand.getText().toString(), model.getText().toString(), edition.getText().toString(), condition.getText().toString(), transmission.getText().toString(), fuel.getText().toString(), enginex);

                        if (result == true) {
                            Toast.makeText(Vehicle_form.this, "Data INserted", Toast.LENGTH_LONG).show();

                        } else
                            Toast.makeText(Vehicle_form.this, "Data not INserted", Toast.LENGTH_LONG).show();


                    }

                }
        );
    }

    */






