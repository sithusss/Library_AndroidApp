package com.example.new_library.admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;

public class AddBook extends AppCompatActivity {

    Button addBook;
    DBHandler dbHandler;

    EditText IdEditText, titleEditText, descEditText, publisherEditText, authorEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        dbHandler = new DBHandler(this);

        IdEditText = findViewById(R.id.book_id);
        titleEditText = findViewById(R.id.book_title);
        descEditText = findViewById(R.id.book_desc);
        publisherEditText = findViewById(R.id.publisher_inbook);
        authorEditText = findViewById(R.id.author_inbook);

        addBook = findViewById(R.id.book);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(IdEditText.getText().toString());
                String title = titleEditText.getText().toString();
                String desc = descEditText.getText().toString();
                String pub = publisherEditText.getText().toString();
                int auth = Integer.parseInt(authorEditText .getText().toString());
                // Start AdminActivity
                dbHandler.addNewBook(id,title,desc,pub,auth);
            }
        });
    }
}
