package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditDataActivity extends AppCompatActivity {

    private Button btnUpdate,btnDelete;
    private EditText phoneE,priceE,brandE,modelE,editionE,engineE;
    DBHandler dbHandler;
    private String brand,model,edition,condition,transmission,fuel,type;
    private int vid,phone,price,engine;
    RadioGroup groupCondition,groupTransmission,groupFuel;
    RadioButton conditionrd,transmissionrd,fuelrd,brandNew,auto,petrol;
    String regexStr = "^[+]?[0-9]{10}$";
    //EditText price,brand1,model,edition,engine,phone;
   // RadioButton condition,transmission,fuel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);


        btnUpdate = (Button)findViewById(R.id.updateBtn);
        btnDelete = (Button)findViewById(R.id.deleteBtn);

        phoneE = (EditText)findViewById(R.id.phone);
        priceE = (EditText)findViewById(R.id.price);
        brandE = (EditText)findViewById(R.id.brand);
        modelE = (EditText)findViewById(R.id.model);
        editionE = (EditText)findViewById(R.id.edition);
        engineE = (EditText)findViewById(R.id.engine);
        groupCondition = (RadioGroup) findViewById(R.id.condition);
        groupTransmission = (RadioGroup) findViewById(R.id.transmssion);
        groupFuel = (RadioGroup) findViewById(R.id.fuel);


        dbHandler  = new DBHandler(this);

        Intent intent = getIntent();



        vid = intent.getIntExtra("vid",-1);
        phone = intent.getIntExtra("phone",-1);
        price = intent.getIntExtra("price",-1);
        brand = intent.getStringExtra("brand");
        model = intent.getStringExtra("model");
        edition = intent.getStringExtra("edition");
        condition = intent.getStringExtra("condition");
        transmission = intent.getStringExtra("transmission");
       fuel = intent.getStringExtra("fuel");
        engine = intent.getIntExtra("engine",-1);
        type = intent.getStringExtra("type");
        brandNew = (RadioButton)findViewById(R.id.brandnew);
        auto = (RadioButton)findViewById(R.id.auto);
        petrol = (RadioButton)findViewById(R.id.petrol);


        brandE.setText(brand);
        modelE.setText(model);
        editionE.setText(edition);
        priceE.setText(Integer.toString(price));
        phoneE.setText(Integer.toString(phone));
        engineE.setText(Integer.toString(engine));
;

        if(condition.equals("Used"))
            groupCondition.check(R.id.used);
        else
            groupCondition.check(R.id.brandnew);

        if(transmission.equals("Automatic"))
            groupTransmission.check(R.id.auto);
        else
            groupTransmission.check(R.id.manual);

        if(fuel.equals("Petrol"))
            groupFuel.check(R.id.petrol);
        else
            groupFuel.check(R.id.diesel);



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (phoneE.getText().toString().length() == 0) {
                    phoneE.setError("Please Enter Phone Number!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                }else if (priceE.getText().toString().isEmpty() || priceE.getText().toString() ==  "0") {
                    priceE.setError("Please Enter Vehicle Price!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                } else if (brandE.getText().toString().isEmpty()) {
                    brandE.setError("Please Enter Vehicle Brand!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                } else if (modelE.getText().toString().isEmpty()) {
                    modelE.setError("Please Enter Vehicle Model!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                } else if (editionE.getText().toString().isEmpty()) {
                    editionE.setError("Please Enter Vehicle Edition!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                } else if (groupCondition.getCheckedRadioButtonId() == -1) {
                    brandNew.setError("Please Select Vehicle Condition!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                } else if (groupTransmission.getCheckedRadioButtonId() == -1) {
                    auto.setError("Please Select Vehicle Transmission!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                } else if (groupFuel.getCheckedRadioButtonId() == -1) {
                    petrol.setError("Please Select Vehicle Fuel Type!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                } else if (engineE.getText().toString().isEmpty() || Integer.parseInt(engineE.getText().toString()) > 10000 ) {
                    engineE.setError("Please Enter Vehicle Engine Capacity!");
                    Toast.makeText(getApplicationContext(), "Failed to post Advertisement", Toast.LENGTH_SHORT).show();
                }else{


                int conditionId = groupCondition.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                conditionrd = (RadioButton) findViewById(conditionId);

                int transmissionId = groupTransmission.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                transmissionrd = (RadioButton) findViewById(transmissionId);

                int fuelId = groupFuel.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                fuelrd = (RadioButton) findViewById(fuelId);


                String phone1 = phoneE.getText().toString();
                int price1 = Integer.parseInt(priceE.getText().toString());
                String brand1 = brandE.getText().toString();
                String model1 = modelE.getText().toString();
                String edition1 = editionE.getText().toString();
                int engine1 = Integer.parseInt(engineE.getText().toString());
                String condition1 = conditionrd.getText().toString();
                String transmission1 = transmissionrd.getText().toString();
                String fuel1 = fuelrd.getText().toString();

                if (type.equals("car")) {
                    int result = dbHandler.update(Integer.parseInt(phone1), price1, brand1, model1, edition1, engine1, condition1, transmission1, fuel1, vid);
                   if(result == 1) {
                       Intent intent = new Intent(EditDataActivity.this,ListDataActivity.class);
                       startActivity(intent);
                       Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_LONG).show();
                   }
                   } else if (type.equals("jeep")) {
                    int result =dbHandler.updateJeep(Integer.parseInt(phone1), price1, brand1, model1, edition1, engine1, condition1, transmission1, fuel1, vid);
                    if(result == 1) {
                        Intent intent = new Intent(EditDataActivity.this,JeepDataActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_LONG).show();
                    }
                    } else {
                    int result =dbHandler.updateBike(Integer.parseInt(phone1), price1, brand1, model1, edition1, engine1, condition1, transmission1, fuel1, vid);
                    if(result == 1) {
                        Intent intent = new Intent(EditDataActivity.this,BikeDataActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_LONG).show();
                    }
                    }


            }
            }

        });


        btnDelete.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                if(type.equals("car")) {
                    int result = dbHandler.delete(vid);

                    if(result == 1){
                        Toast.makeText(getApplicationContext(), "Advertisement Deleted Successfully", Toast.LENGTH_LONG).show();
                    }


                }else if(type.equals("jeep")){
                    int result = dbHandler.deleteJeep(vid);

                    if(result == 1){
                        Toast.makeText(getApplicationContext(), "Advertisement Deleted Successfully", Toast.LENGTH_LONG).show();
                    }

                }else{
                    int result =   dbHandler.deleteBike(vid);

                    if(result == 1){
                        Toast.makeText(getApplicationContext(), "Advertisement Deleted Successfully", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });



    }
}
