package com.example.android.habit_tracker.Files;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habit_tracker.Files.HabitTrackerContract.HabitInput;



/**
 * Created by mr on 18-03-2017.
 */

public class HabitTrackerHelper extends SQLiteOpenHelper
{
    public static final String DB_NAME ="habittracker.db";
    public static final int DB_VRS = 4;
    public HabitTrackerHelper(Context context){super(context,DB_NAME,null,DB_VRS);}
    public static final String CREATE_TABLE = "CREATE TABLE " + HabitInput.TABLE_NAME + "(" +HabitInput._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HabitInput.COLUMN_FIRST_NAME +" TEXT NOT NULL , "+ HabitInput.COLUMN_LAST_NAME +" TEXT NOT NULL,   "
            + HabitInput.COLUMN_AGE + " INTEGER NOT NULL DEFAULT 0, "+HabitInput.COLUMN_CITY+" TEXT NOT NULL, "+HabitInput.COLUMN_COUNTRY+" TEXT NOT NULL  );";
    public static final String DELETE_TABLE ="DROP TABLE IF EXISTS " + HabitInput.TABLE_NAME + ";";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
