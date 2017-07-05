package com.example.android.habit_tracker.Files;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by mr on 18-03-2017.
 */

public class HabitTrackerContract {
    public static final String CONTENT_AUTHORITY = "com.example.android.habit_example";
    public static final Uri BASE_CONTENT = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_HABIT = "Himanshu";

    public static final class HabitInput implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT.buildUpon().appendPath(PATH_HABIT).build();
        public static final String TABLE_NAME = "Habit";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_FIRST_NAME = "Habits";
        public static final String COLUMN_LAST_NAME = "Habits1";
        public static final String COLUMN_AGE = "Age";
        public static final String COLUMN_CITY = "City";
        public static final String COLUMN_COUNTRY="Country";
    }
}