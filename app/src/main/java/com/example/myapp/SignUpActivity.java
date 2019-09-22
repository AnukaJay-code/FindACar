package com.example.myapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.LoginMain;

public class SignUpActivity extends AppCompatActivity {
    private EditText editTextUsername,editTextPassword,editTextFullName,editTextEmail;
    Button btnreg,btncancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle(R.string.signup);

        editTextUsername = (EditText)findViewById(R.id.editText);
        editTextPassword = (EditText)findViewById(R.id.editText4);
        editTextFullName = (EditText)findViewById(R.id.editText5);
        editTextEmail = (EditText)findViewById(R.id.editText6);
        btnreg = (Button)findViewById(R.id.button3);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSave_onClick(v);
            }
        });
        btncancel = (Button)findViewById(R.id.button4);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginMain.class);
                startActivity(intent);
            }
        });

    }

    public void buttonSave_onClick(View view){
        try{
            AccountDB accountDB = new AccountDB(getApplicationContext());
            Account account = new Account();
            account.setEmail(editTextEmail.getText().toString());
            account.setFullname(editTextFullName.getText().toString());
            account.setPassword(editTextPassword.getText().toString());
            account.setUsername(editTextUsername.getText().toString());
            Account temp = accountDB.checkUserName(editTextUsername.getText().toString());

            if(temp==null){

                if(accountDB.create(account)){
                    Intent intent = new Intent(SignUpActivity.this, LoginMain.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Account Created !",Toast.LENGTH_LONG).show();

                }else {

                    Toast.makeText(getApplicationContext(),"Account not created !",Toast.LENGTH_LONG).show();
                }
            }else {


                Toast.makeText(getApplicationContext(),"User Name Exists!",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Exception Error",Toast.LENGTH_LONG).show();
        }
    }
}
