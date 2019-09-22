package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Allocation;

public class DBHandler extends SQLiteOpenHelper {

  public static final String DATABASE_NAME = "Vehicles.db";
private String Table_Name;
  // public static final String TABLE_NAME = "BEST";
    //public static final String COL1 = "phone";




    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

/*
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + VehicleMaster.Vehicles.TABLE_NAME + "("+
                VehicleMaster.Vehicles.COLUMN_NAME_VID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VehicleMaster.Vehicles.COLUMN_NAME_PHONE + "INTEGER," +
                VehicleMaster.Vehicles.COLUMN_NAME_PRICE + "INTEGER," +
                VehicleMaster.Vehicles.COLUMN_NAME_BRAND + "TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_MODEL + "TEXT,"+
                VehicleMaster.Vehicles.COLUMN_NAME_EDITION + "TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_CONDITION +  "TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION + "TEXT,"+
                VehicleMaster.Vehicles.COLUMN_NAME_FUEL + "TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_ENGINE + "INTEGER)";


        db.execSQL(SQL_CREATE_ENTRIES);
*/
/*
       String SQL_CREATE_ENTRIES = ("CREATE TABLE " + TABLE_NAME + "( phone INTEGER PRIMARY KEY)");


       db.execSQL(SQL_CREATE_ENTRIES);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


       // db.execSQL("DROP TABLE IF EXISTS "+VehicleMaster.Vehicles.TABLE_NAME);
        //onCreate(db);

      // db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
       //onCreate(db);
    }




    public boolean addData(int phone,int price,String brand,String model,String edition,String condition,String transmission,String fuel,int engine){

        SQLiteDatabase db =  getWritableDatabase();



            String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " + VehicleMaster.Vehicles.TABLE_NAME+ "("+
                    VehicleMaster.Vehicles.COLUMN_NAME_VID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    VehicleMaster.Vehicles.COLUMN_NAME_PHONE + " INTEGER," +
                    VehicleMaster.Vehicles.COLUMN_NAME_PRICE + " INTEGER," +
                    VehicleMaster.Vehicles.COLUMN_NAME_BRAND + " TEXT," +
                    VehicleMaster.Vehicles.COLUMN_NAME_MODEL + " TEXT,"+
                    VehicleMaster.Vehicles.COLUMN_NAME_EDITION + " TEXT," +
                    VehicleMaster.Vehicles.COLUMN_NAME_CONDITION +  " TEXT," +
                    VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION + " TEXT,"+
                    VehicleMaster.Vehicles.COLUMN_NAME_FUEL + " TEXT," +
                    VehicleMaster.Vehicles.COLUMN_NAME_ENGINE + " INTEGER)";

            db.execSQL(SQL_CREATE_ENTRIES);






      //  db.execSQL("DROP TABLE IF EXISTS "+VehicleMaster.Vehicles.TABLE_NAME);


        ContentValues values = new ContentValues();

        values.put(VehicleMaster.Vehicles.COLUMN_NAME_PHONE,phone);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_PRICE,price);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_BRAND,brand);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_MODEL,model);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_EDITION,edition);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_CONDITION,condition);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION,transmission);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_FUEL,fuel);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_ENGINE,engine);

        long result = db.insert(VehicleMaster.Vehicles.TABLE_NAME,null,values);

        if(result == -1)
            return false;
        else
            return true;


    }


    public boolean addJeep(int phone,int price,String brand,String model,String edition,String condition,String transmission,String fuel,int engine){

        SQLiteDatabase db =  getWritableDatabase();



        String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " + VehicleMaster.Vehicles.TABLE_NAME2+ "("+
                VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VehicleMaster.Vehicles.COLUMN_NAME_PHONE2 + " INTEGER," +
                VehicleMaster.Vehicles.COLUMN_NAME_PRICE2 + " INTEGER," +
                VehicleMaster.Vehicles.COLUMN_NAME_BRAND2 + " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_MODEL2 + " TEXT,"+
                VehicleMaster.Vehicles.COLUMN_NAME_EDITION2 + " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_CONDITION2 +  " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION2 + " TEXT,"+
                VehicleMaster.Vehicles.COLUMN_NAME_FUEL2 + " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_ENGINE2 + " INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);



        //  db.execSQL("DROP TABLE IF EXISTS "+VehicleMaster.Vehicles.TABLE_NAME);


        ContentValues values = new ContentValues();

        values.put(VehicleMaster.Vehicles.COLUMN_NAME_PHONE2,phone);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_PRICE2,price);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_BRAND2,brand);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_MODEL2,model);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_EDITION2,edition);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_CONDITION2,condition);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION2,transmission);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_FUEL2,fuel);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_ENGINE2,engine);

        long result = db.insert(VehicleMaster.Vehicles.TABLE_NAME2,null,values);

        if(result == -1)
            return false;
        else
            return true;


    }

    public boolean addBike(int phone,int price,String brand,String model,String edition,String condition,String transmission,String fuel,int engine){

        SQLiteDatabase db =  getWritableDatabase();


        String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " + VehicleMaster.Vehicles.TABLE_NAME3+ "("+
                VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VehicleMaster.Vehicles.COLUMN_NAME_PHONE3 + " INTEGER," +
                VehicleMaster.Vehicles.COLUMN_NAME_PRICE3 + " INTEGER," +
                VehicleMaster.Vehicles.COLUMN_NAME_BRAND3 + " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_MODEL3 + " TEXT,"+
                VehicleMaster.Vehicles.COLUMN_NAME_EDITION3 + " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_CONDITION3 +  " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION3 + " TEXT,"+
                VehicleMaster.Vehicles.COLUMN_NAME_FUEL3 + " TEXT," +
                VehicleMaster.Vehicles.COLUMN_NAME_ENGINE3 + " INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);



        //  db.execSQL("DROP TABLE IF EXISTS "+VehicleMaster.Vehicles.TABLE_NAME);


        ContentValues values = new ContentValues();

        values.put(VehicleMaster.Vehicles.COLUMN_NAME_PHONE3,phone);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_PRICE3,price);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_BRAND3,brand);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_MODEL3,model);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_EDITION3,edition);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_CONDITION3,condition);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION3,transmission);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_FUEL3,fuel);
        values.put(VehicleMaster.Vehicles.COLUMN_NAME_ENGINE3,engine);

        long result = db.insert(VehicleMaster.Vehicles.TABLE_NAME3,null,values);

        if(result == -1)
            return false;
        else
            return true;


    }


    public Cursor getAllData(){

        SQLiteDatabase db =  getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+VehicleMaster.Vehicles.TABLE_NAME,null);


        return res;
    }

    public Cursor getJeepData(){

        SQLiteDatabase db =  getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+VehicleMaster.Vehicles.TABLE_NAME2,null);


        return res;
    }

    public Cursor getBikeData(){

        SQLiteDatabase db =  getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+VehicleMaster.Vehicles.TABLE_NAME3,null);


        return res;
    }


public Cursor getItemID(int vid){

    SQLiteDatabase db =  getWritableDatabase();

    String query = "SELECT " + VehicleMaster.Vehicles.COLUMN_NAME_VID + " FROM " +VehicleMaster.Vehicles.TABLE_NAME + " WHERE " + VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" +vid + "'";

    Cursor data = db.rawQuery(query,null);
    return data;

    }


    public int update(int phone,int price,String brand,String model,String edition,int engine,String condition,String transmission,String fuel,int vid){

        SQLiteDatabase db =  getWritableDatabase();

        String query1 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_PHONE+ " = '" +phone +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query2 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_PRICE+ " = '" +price +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query3 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_BRAND+ " = '" +brand +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query4 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_MODEL+ " = '" +model +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query5 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_EDITION+ " = '" +edition +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query6 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_ENGINE+ " = '" +engine +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query7 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_CONDITION+ " = '" +condition +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query8 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION+ " = '" +transmission +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;
        String query9 = "Update " +VehicleMaster.Vehicles.TABLE_NAME + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_FUEL+ " = '" +fuel +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID + " = '" + vid + "'" ;



        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
        db.execSQL(query6);
        db.execSQL(query7);
        db.execSQL(query8);
        db.execSQL(query9);


        return 1;
    }


    public int updateJeep(int phone,int price,String brand,String model,String edition,int engine,String condition,String transmission,String fuel,int vid){

        SQLiteDatabase db =  getWritableDatabase();

        String query1 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_PHONE2+ " = '" +phone +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query2 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_PRICE2+ " = '" +price +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query3 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_BRAND2+ " = '" +brand +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query4 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_MODEL2+ " = '" +model +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query5 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_EDITION2+ " = '" +edition +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query6 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_ENGINE2+ " = '" +engine +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query7 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_CONDITION2+ " = '" +condition +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query8 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION2+ " = '" +transmission +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;
        String query9 = "Update " +VehicleMaster.Vehicles.TABLE_NAME2 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_FUEL2+ " = '" +fuel +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2 + " = '" + vid + "'" ;



        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
        db.execSQL(query6);
        db.execSQL(query7);
        db.execSQL(query8);
        db.execSQL(query9);

        return 1;
    }

    public int updateBike(int phone,int price,String brand,String model,String edition,int engine,String condition,String transmission,String fuel,int vid){

        SQLiteDatabase db =  getWritableDatabase();

        String query1 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_PHONE3+ " = '" +phone +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query2 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_PRICE3+ " = '" +price +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query3 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_BRAND3+ " = '" +brand +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query4 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_MODEL3+ " = '" +model +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query5 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_EDITION3+ " = '" +edition +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query6 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_ENGINE3+ " = '" +engine +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query7 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_CONDITION3+ " = '" +condition +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query8 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_TRANSMISSION3+ " = '" +transmission +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;
        String query9 = "Update " +VehicleMaster.Vehicles.TABLE_NAME3 + " SET " +VehicleMaster.Vehicles.COLUMN_NAME_FUEL3+ " = '" +fuel +"' " +" WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3 + " = '" + vid + "'" ;



        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
        db.execSQL(query6);
        db.execSQL(query7);
        db.execSQL(query8);
        db.execSQL(query9);

        return 1;
    }


    public int delete(int vid){

        SQLiteDatabase db =  getWritableDatabase();

        String query = "Delete FROM  " +VehicleMaster.Vehicles.TABLE_NAME + " WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID+ " = '" +vid +"'" ;
        db.execSQL(query);

        return 1;

    }

    public int deleteJeep(int vid){

        SQLiteDatabase db =  getWritableDatabase();

        String query = "Delete FROM  " +VehicleMaster.Vehicles.TABLE_NAME2 + " WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID2+ " = '" +vid +"'" ;
        db.execSQL(query);

        return 1;
    }


    public int deleteBike(int vid){

        SQLiteDatabase db =  getWritableDatabase();

        String query = "Delete FROM  " +VehicleMaster.Vehicles.TABLE_NAME3 + " WHERE " +VehicleMaster.Vehicles.COLUMN_NAME_VID3+ " = '" +vid +"'" ;
        db.execSQL(query);
        return 1;

    }





}
