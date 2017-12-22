package com.example.user.sqlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by User on 22/12/2017.
 */

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void saveRecord(View v){

        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        UserRecord userRecord = new UserRecord();
        userRecord.setName(editTextName.getText().toString());
        userRecord.setPhone(editTextPhone.getText().toString());
        userRecord.setEmail(editTextEmail.getText().toString());

        UserSQLHelper userDataSource = new UserSQLHelper(this);
        userDataSource.insertUser(userRecord);
        this.finish();

    }
}
