package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.LoginMain;

public class WelcomeActivity extends AppCompatActivity {
    private TextView textViewWelcome;
    private Button buttonchange,buttonLogOut;
    private Account account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitle(R.string.welcomeMsg);
        textViewWelcome = findViewById(R.id.textView4);

        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        textViewWelcome.setText(getString(R.string.welcomeMsg) + " " + account.getUsername());

        buttonchange = (Button)findViewById(R.id.button5);
        buttonchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(WelcomeActivity.this, ProfileActivity.class);
                intent1.putExtra("account",account);
                startActivity(intent1);
            }
        });
        buttonLogOut = (Button)findViewById(R.id.button6);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(WelcomeActivity.this, LoginMain.class);
                startActivity(intent2);
            }
        });
    }
}
