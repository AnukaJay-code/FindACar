package com.example.myapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = questions.class,version = 1, exportSchema = false)
public abstract class QuestionDatabase extends RoomDatabase {

    private static QuestionDatabase instance;// only can create one instance

    public abstract questionDAO questionDAO();

    //create db
    public static synchronized QuestionDatabase getInstance(Context context){
        //can on
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    QuestionDatabase.class,"note_database").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;
    }

    public static QuestionDatabase.Callback roomCallBack = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private questionDAO questionDAO;

        private PopulateDBAsyncTask(QuestionDatabase db){
            questionDAO = db.questionDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            questionDAO.insert(new questions("question 1","description 1"));
            questionDAO.insert(new questions("question 2","description 2"));
            questionDAO.insert(new questions("question 3","description 3"));
            return null;
        }
    }
}
