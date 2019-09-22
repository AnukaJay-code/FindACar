package com.example.myapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionRepo {

    private com.example.myapp.questionDAO questionDAO;
    private LiveData<List<questions>> allQuestions;

    public QuestionRepo(Application application){
        QuestionDatabase database = QuestionDatabase.getInstance(application);
        questionDAO = database.questionDAO();
        allQuestions = questionDAO.getAllQuestions();
    }

    public void insert(questions q){
        new InsertNoteAsyncTask(questionDAO).execute(q);
    }

    public void update(questions q){ new UpdateNoteAsyncTask(questionDAO).execute(q); }

    public void delete(questions q){

        new DeleteNoteAsyncTask(questionDAO).execute(q);
    }

    public void deleteAllNotes(){

        new DeleteAllNoteAsyncTask(questionDAO).execute();
    }

    public LiveData<List<questions>> getAllQuestions(){
        return allQuestions;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<questions, Void,  Void> {
        private questionDAO questionDAO;

        private InsertNoteAsyncTask(questionDAO noteDAO){
            this.questionDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(questions... questions) {
            questionDAO.insert(questions[0]);
            return null;
        }
    }

    private static class  UpdateNoteAsyncTask extends AsyncTask<questions, Void,  Void> {
        private questionDAO questionDAO;

        private  UpdateNoteAsyncTask(questionDAO noteDAO){
            this.questionDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(questions... questions) {
            questionDAO.update(questions[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<questions, Void,  Void> {
        private questionDAO questionDAO;

        private DeleteNoteAsyncTask(questionDAO noteDAO){
            this.questionDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(questions... questions) {
            questionDAO.delete(questions[0]);
            return null;
        }
    }

    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void,  Void>{
        private questionDAO questionDAO;

        private DeleteAllNoteAsyncTask(questionDAO noteDAO){
            this.questionDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            questionDAO.deleteAllquestions();
            return null;
        }
    }

}
