package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivityFAQ extends AppCompatActivity {
    public static final int ADD_QUESTION_REQUEST = 1;
    public static final int EDIT_QUESTION_REQUEST = 2;

    QuestionView questionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_faq);

        Intent intent = getIntent();

        FloatingActionButton buttonAddQuestion = findViewById(R.id.button_add_question);
        buttonAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityFAQ.this, activity_add_question.class);
                startActivityForResult(intent, ADD_QUESTION_REQUEST);
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setHasFixedSize(true);

//        final QuestionAdapter adapter = new QuestionAdapter();
//        view.setAdapter(adapter);
        final QuestionAdapter adapter = new QuestionAdapter();
        view.setAdapter(adapter);

        questionView = ViewModelProviders.of(this).get(QuestionView.class);
        questionView.getAllquestions().observe(this, new Observer<List<questions>>() {
            @Override
            public void onChanged(List<questions> questions) {

                adapter.submitList(questions);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                questionView.delete(adapter.getQestionsAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivityFAQ.this, "Question Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(view);

        adapter.setOnItemClickListner(new QuestionAdapter.OnItemClickListener() {
            @Override //handel click here
            public void onItemClick(questions questions) {
                Intent intent = new Intent(MainActivityFAQ.this,activity_add_question.class);
                intent.putExtra(activity_add_question.EXTRA_ID, questions.getId());
                intent.putExtra(activity_add_question.EXTRA_QUESTION, questions.getQuestions());
                intent.putExtra(activity_add_question.EXTRA_DESCRIPTION, questions.getDescription());

                startActivityForResult(intent, EDIT_QUESTION_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //to find what results we are handeling
        if (requestCode == ADD_QUESTION_REQUEST && resultCode == RESULT_OK) { //add
            //GET THE EXTRAS THAT WE SEND
            String question = data.getStringExtra(activity_add_question.EXTRA_QUESTION);
            String description = data.getStringExtra(activity_add_question.EXTRA_DESCRIPTION);

            //passing the data to questions class
            questions q = new questions(question, description);

            questionView.insert(q);

            Toast.makeText(this, "Question Added", Toast.LENGTH_SHORT).show();

        } else if (requestCode == EDIT_QUESTION_REQUEST && resultCode == RESULT_OK){ //edit

            int id = data.getIntExtra(activity_add_question.EXTRA_ID,-1);

            if( id == -1){
                Toast.makeText(this, "Question cannot be updated ", Toast.LENGTH_SHORT).show();
                return;
            }

            //GET THE EXTRAS THAT WE SEND
            String question = data.getStringExtra(activity_add_question.EXTRA_QUESTION);
            String description = data.getStringExtra(activity_add_question.EXTRA_DESCRIPTION);

            questions q =new questions(question,description);
            q.setId(id);
            questionView.update(q);

            Toast.makeText(this, "Question Updated", Toast.LENGTH_SHORT).show();


        }else { // if cancelled
            Toast.makeText(this, "Question adding Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_questions:
                questionView.deleteAll();
                Toast.makeText(this, "All Questions are Deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
