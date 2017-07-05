package com.example.android.habit_tracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.habit_tracker.Files.HabitTrackerContract.HabitInput;
import com.example.android.habit_tracker.Files.HabitTrackerHelper;


public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onStart(){super.onStart();}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dispValues();
        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                insertValues();
                TextView textView = (TextView) findViewById(R.id.data_view);
                textView.setText("");
                dispValues();
            }
        });
        Button button2 = (Button) findViewById(R.id.delete);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                TextView textView = (TextView) findViewById(R.id.data_view);
                textView.setText(null);
            }
        });
    }
    HabitTrackerHelper mHelper = new HabitTrackerHelper(this);
    public void insertValues() {
        ContentValues values = new ContentValues();
        values.put(HabitInput.COLUMN_AGE, "19");
        values.put(HabitInput.COLUMN_FIRST_NAME, "Himanshu");
        values.put(HabitInput.COLUMN_LAST_NAME,"Dhiman");
        values.put(HabitInput.COLUMN_CITY,"Kurukshetra");
        values.put(HabitInput.COLUMN_COUNTRY,"India");
        db.insert(HabitInput.TABLE_NAME,null, values);
    }
    private void dispValues() {
        db = mHelper.getReadableDatabase();
        Cursor cursor=readMethod();
        TextView displayView = (TextView) findViewById(R.id.data_view);
        try {
            int idColumnIndex = cursor.getColumnIndex(HabitInput._ID);
            int habitColumnIndex = cursor.getColumnIndex(HabitInput.COLUMN_FIRST_NAME);
            int habit1ColumnIndex = cursor.getColumnIndex(HabitInput.COLUMN_LAST_NAME);
            int ageColumnIndex = cursor.getColumnIndex(HabitInput.COLUMN_AGE);
            int habit3ColumnIndex = cursor.getColumnIndex(HabitInput.COLUMN_CITY);
            int habit2ColumnIndex = cursor.getColumnIndex(HabitInput.COLUMN_COUNTRY);
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentHabit = cursor.getString(habitColumnIndex);
                String currentHabit1 = cursor.getString(habit1ColumnIndex);
                int age = cursor.getInt(ageColumnIndex);
                String currentHabit2 = cursor.getString(habit2ColumnIndex);
                String currentHabit3 = cursor.getString(habit3ColumnIndex);
                displayView.append(("\n" + currentID + "  " + currentHabit +"  "+ currentHabit1 +" "+age+" "+currentHabit3+"  "+currentHabit2));
            }
        } finally {
            cursor.close();
        }
    }
    public Cursor readMethod() {
        String[] projection = {
                HabitInput._ID,HabitInput.COLUMN_FIRST_NAME,HabitInput.COLUMN_LAST_NAME,HabitInput.COLUMN_AGE,HabitInput.COLUMN_CITY,HabitInput.COLUMN_COUNTRY
        };
        db = mHelper.getReadableDatabase();
        Cursor cursor =
                db.query(HabitInput.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
}
