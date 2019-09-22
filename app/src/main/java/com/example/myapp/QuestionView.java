package com.example.myapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapp.QuestionRepo;
import com.example.myapp.questions;

import java.util.List;

public class QuestionView extends AndroidViewModel {
    private QuestionRepo repo;
    private LiveData<List<questions>> allQuestions;

    public QuestionView(@NonNull Application application) {
        super(application);
        repo = new QuestionRepo(application);
        allQuestions = repo.getAllQuestions();
    }


    public void insert(questions q){
        repo.insert(q);
    }

    public void delete(questions q){
        repo.delete(q);
    }

    public void update(questions q) { repo.update(q); }

    public void deleteAll(){
        repo.deleteAllNotes();
    }

    public LiveData<List<questions>> getAllquestions(){
        return allQuestions;
    }
}
