package com.example.myapp;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.AccountDB;
import com.example.myapp.Account;

public class ProfileActivity extends AppCompatActivity {
    private EditText editTextUsername,editTextPassword,editTextFullname,editTextemail;
    private Button buttonsave,buttonCancel;
    private Account account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(R.string.changepro);

        editTextUsername = (EditText)findViewById(R.id.editText7);
        editTextPassword = (EditText)findViewById(R.id.editText8);
        editTextFullname = (EditText)findViewById(R.id.editText9);
        editTextemail = (EditText)findViewById(R.id.editText10);
        loadData();
        buttonsave = (Button)findViewById(R.id.button7);
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsave_onClick(v);
            }
        });

        buttonCancel = (Button)findViewById(R.id.button8);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,WelcomeActivity.class);
                intent.putExtra("account",account);
                startActivity(intent);
            }
        });
    }

    public void buttonsave_onClick(View view){
        try{
            AccountDB accountDB = new AccountDB(getApplicationContext());
            Account currentAccount = accountDB.find(account.getId());
            String newUsername = editTextUsername.getText().toString();
            Account temp = accountDB.checkUserName(newUsername);
            if(!newUsername.equalsIgnoreCase(currentAccount.getUsername())&& temp != null){

                Toast.makeText(getApplicationContext(),"User Name Exists !",Toast.LENGTH_LONG).show();
                return;
            }

            currentAccount.setUsername(editTextUsername.getText().toString());
            currentAccount.setFullname(editTextFullname.getText().toString());
            currentAccount.setEmail(editTextemail.getText().toString());
            String password = editTextPassword.getText().toString();
            if(!password.isEmpty()){
                currentAccount.setPassword(editTextPassword.getText().toString());
            }
            if(accountDB.update(currentAccount)){
                Intent intent = new Intent(ProfileActivity.this,WelcomeActivity.class);
                intent.putExtra("account",account);
                startActivity(intent);
            }else {

                Toast.makeText(getApplicationContext(),"Failed !",Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Exception error!",Toast.LENGTH_LONG).show();
        }
    }

    public void loadData(){

        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        editTextemail.setText(account.getEmail());
        editTextFullname.setText(account.getFullname());
        editTextUsername.setText(account.getUsername());


    }
}
