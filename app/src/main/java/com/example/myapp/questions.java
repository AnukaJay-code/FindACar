package com.example.myapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions_table") //using this ROOM ANNOTATION it will create code to make sqlite db
public class questions {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String questions;

    private String description;

    //
    public questions(String questions, String description) {
        this.questions = questions;
        this.description = description;
    }

    //Room use this to make the id in the Note object
    public void setId(int id) {
        this.id = id;
    }

    //
    public int getId() {
        return id;
    }

    public String getQuestions() {
        return questions;
    }

    public String getDescription() {
        return description;
    }
}