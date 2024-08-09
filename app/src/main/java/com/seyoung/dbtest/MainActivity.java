package com.seyoung.dbtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private UserDatabaseHelper mDBHelper;
    Button insertBtn;
    EditText idEditText;
    EditText passwordEditText;
    EditText useTimeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = findViewById(R.id.id_editText);
        passwordEditText = findViewById(R.id.password_editText);
        useTimeEditText = findViewById(R.id.useTime_editText);
        insertBtn = findViewById(R.id.insert_button);
        mDBHelper = new UserDatabaseHelper(this);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDBHelper.InsertUser(idEditText.getText().toString(), passwordEditText.getText().toString(), useTimeEditText.getText().toString());
                Log.d("idEditText", idEditText.getText().toString());
                Log.d("passwordEditText", passwordEditText.getText().toString());
                Log.d("useTimeEditText", useTimeEditText.getText().toString());
            }
        });
    }
}