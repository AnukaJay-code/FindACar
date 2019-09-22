package com.example.myapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface questionDAO {
    //Room will automaticly generate the code
    @Insert
    void insert(questions questions);

    @Update
    void update(questions questions);

    @Delete
    void delete(questions questions);

    //we dont have ready made annotations so we write the code in query
    @Query("DELETE FROM questions_table")
    void deleteAllquestions();

    @Query("SELECT * FROM questions_table ")
    LiveData<List<questions>> getAllQuestions(); //show when the questiojn is added
}
