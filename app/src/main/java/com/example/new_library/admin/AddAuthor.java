package com.example.new_library.admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;

public class AddAuthor extends AppCompatActivity {

    Button addAuthor;
    DBHandler dbHandler;

    EditText idEditText, nameEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);


        dbHandler = new DBHandler(this);

        idEditText = findViewById(R.id.author_id);
        nameEditText = findViewById(R.id.author_name);


        addAuthor = findViewById(R.id.author);

        addAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                Integer id = Integer.parseInt(idEditText.getText().toString());
                // Start AdminActivity
                dbHandler.addNewAuthor(id,name);
            }
        });
    }
}
