package com.weboniselab.meghana.android.app.recyclerandcardview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 9/10/15.
 */
public class DatabaseOperations extends SQLiteOpenHelper{
    Context mcontext;
    private static final int DB_VERSION=1;


    public static final String createTable=" CREATE TABLE " +Constants.TABLE_NAME+ " ( " +Constants.COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT , "
            +Constants.COLUMN_NAME+ " TEXT , " +Constants.COLUMN_AGE+ " TEXT ) ";

    public DatabaseOperations(Context context){
        super(context,Constants.DATABASE_NAME,null,DB_VERSION);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addDetailsToDatabase(String name,String age){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constants.COLUMN_NAME,name);
        values.put(Constants.COLUMN_AGE,age);
        database.insert(Constants.TABLE_NAME, null, values);
        database.close();
    }

    public List<Model> getAllDetails(){
        List<Model> details=new ArrayList<Model>();
        String getDetailsQuery="SELECT * FROM " +Constants.TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(getDetailsQuery, null);
        try {
            if (cursor.moveToFirst()) do{
                Model detailsOfPerson=new Model();
                detailsOfPerson.setId(cursor.getInt(cursor.getColumnIndex(Constants.COLUMN_ID)));
                detailsOfPerson.setName(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_NAME)));
                detailsOfPerson.setAge(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_AGE)));
                details.add(detailsOfPerson);
            }while (cursor.moveToNext());
        }catch (Exception e){
            e.printStackTrace();
        }
        return details;
    }

}
