package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginMain extends AppCompatActivity {

    private EditText editTextUsername,editTextPassword;
    private Button buttonLogin,buttonSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        editTextUsername = (EditText)findViewById(R.id.editText2);
        editTextPassword = (EditText)findViewById(R.id.editText3);
        buttonLogin = (Button)findViewById(R.id.button);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogin_onClick(v);
            }
        });
        buttonSignUp = (Button)findViewById(R.id.button2);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSignUp_onClick(v);
            }
        });

    }

    public void buttonSignUp_onClick(View view){
        Intent intent = new Intent(LoginMain.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void buttonLogin_onClick(View view){
        AccountDB accountDB = new AccountDB(getApplicationContext());
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        Account account = accountDB.login(username,password);
        if(account==null){


            Toast.makeText(getApplicationContext(),"Invalid Username or Password!",Toast.LENGTH_LONG).show();
        }else {

            Intent intent = new Intent(LoginMain.this, WelcomeActivity.class);
            intent.putExtra("account",account);
            startActivity(intent);
        }

    }

}
