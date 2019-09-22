package com.example.myapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;

public class activity_add_question extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.example.rentacar.EXTRA_ID";
    public static final String EXTRA_QUESTION =
            "com.example.rentacar.EXTRA_QUESTION";
    public static final String EXTRA_DESCRIPTION =
            "com.example.rentacar.EXTRA_DESCRIPTION";

    private EditText question;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        question = findViewById(R.id.edit_text_question);
        description = findViewById(R.id.edit_text_description);

        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = new Intent();

        if (intent.hasExtra(EXTRA_ID)) {
            //setTitle("Edit Question");
            setTitle("Edit Question");
            question.setText(intent.getStringExtra(EXTRA_QUESTION));
            //question.setText(intent.getStringExtra(EXTRA_QUESTION));
            description.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            //description.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
        } else {
            setTitle("Add Question");
        }

    }

    private void saveQuestion() {
        String q = question.getText().toString();
        String d = description.getText().toString();

        //trim = to get rid of empty spaces
        if (q.trim().isEmpty() || d.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a Question and description", Toast.LENGTH_SHORT).show();
            return; //exit the method
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_QUESTION, q);
        data.putExtra(EXTRA_DESCRIPTION, d);

        int id = getIntent().getIntExtra(EXTRA_ID,-1);
        if( id != -1){
            data.putExtra(EXTRA_ID,id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    //tells to use add_question_menu as the menu of this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_question_menu, menu);
        return true;//show menu
    }


    public void onClickSave(View view){

        saveQuestion();

        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_question:
                saveQuestion();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
