package com.boucetta.todolistactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;


public class Dbmanager extends SQLiteOpenHelper {

    private   static final String DB_NAME = "listTasksDb";
    private   static final int DB_VERSION = 1;
    private   static final String Col_Task = "task";
    private   static final String Col_Delay = "delay";
    private static final String ID_COL = "id";
    private   static final String TABLE_NAME = "listTasks";




    public Dbmanager(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String query = "CREATE TABLE " +TABLE_NAME + "("
             +ID_COL+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
         +Col_Task +" TEXT, "
             + Col_Delay+ " TEXT) ";

    db.execSQL(query);




    }


    public void addTask(String task, String delay) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_Task,task);
        contentValues.put(Col_Delay,delay);
        db.insert(TABLE_NAME,null,contentValues);
        db.close();

    }


    public ArrayList<ListModal> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorLists = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<ListModal> listModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorLists.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                listModalArrayList.add(new ListModal(cursorLists.getString(1),
                        cursorLists.getString(2)));
            } while (cursorLists.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorLists.close();
        return listModalArrayList;
    }


    public void updateCourse(String originalTask, String task,
                             String delay) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        values.put(Col_Task, task);
        values.put(Col_Delay,delay);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "task=?", new String[]{originalTask});
        db.close();
    }


    // below is the method for deleting our course.
    public void deleteCourse(String task) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "task=?", new String[]{task});
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME );
        onCreate(db);


    }
}
