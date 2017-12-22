package com.example.user.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22/12/2017.
 */

public class UserSQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserContract.User.TABLE_NAME + "(" +
                    UserContract.User.COLUMN_NAME + " TEXT," +
                    UserContract.User.COLUMN_PHONE + " TEXT," +
                    UserContract.User.COLUMN_EMAIL + " TEXT)";

    private String[] allColumn = {UserContract.User.COLUMN_NAME, UserContract.User.COLUMN_PHONE, UserContract.User.COLUMN_EMAIL};

    public UserSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertUser(UserRecord userRecord){

        ContentValues values = new ContentValues();
        values.put(UserContract.User.COLUMN_NAME, userRecord.getName());
        values.put(UserContract.User.COLUMN_PHONE, userRecord.getPhone());
        values.put(UserContract.User.COLUMN_EMAIL, userRecord.getEmail());

        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(UserContract.User.TABLE_NAME, null, values);

        database.close();
    }

    public List<UserRecord> getAllUsers(){

        List<UserRecord> records = new ArrayList<UserRecord>();
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.query(UserContract.User.TABLE_NAME,
                allColumn,null,null,null,null,null);

        return records;
    }
}
