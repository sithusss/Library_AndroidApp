package com.example.new_library.admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;

public class AddCopies extends AppCompatActivity {

    Button addCopies;
    DBHandler dbHandler;

    EditText bookidEditText, branchidText, accessnoEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copies);


        dbHandler = new DBHandler(this);

        bookidEditText = findViewById(R.id.bookid_incopy);
        branchidText = findViewById(R.id.branchid_incopy);
        accessnoEditText = findViewById(R.id.access_number);


        addCopies = findViewById(R.id.member);

        addCopies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String branchid = branchidText.getText().toString();
                String acc_no= accessnoEditText.getText().toString();
                int bookid = Integer.parseInt(bookidEditText.getText().toString());
                // Start AdminActivity
                dbHandler.addNewCopies(bookid,branchid,acc_no);
            }
        });
    }
}
