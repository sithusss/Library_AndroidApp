package com.example.new_library.admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;

public class AddBranch extends AppCompatActivity {

    Button addBranch;
    DBHandler dbHandler;

    EditText idEditText, nameEditText, addressEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);


        dbHandler = new DBHandler(this);

        idEditText = findViewById(R.id.branch_id);
        nameEditText = findViewById(R.id.branch_name);
        addressEditText = findViewById(R.id.branch_addr);


        addBranch = findViewById(R.id.member);

        addBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();

                dbHandler.addNewBranch(id,name,address);
            }
        });
    }
}
