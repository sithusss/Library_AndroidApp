package com.example.new_library.admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;

public class AddPublisher extends AppCompatActivity {

    Button addPublisher;
    DBHandler dbHandler;

    EditText  nameEditText, addressEditText, phoneEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher);


        dbHandler = new DBHandler(this);


        nameEditText = findViewById(R.id.pub_name);
        addressEditText = findViewById(R.id.pub_addr);
        phoneEditText = findViewById(R.id.pub_phone);


        addPublisher = findViewById(R.id.publisher);

        addPublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                // Start AdminActivity
                dbHandler.addNewPublisher(name,address,phone);
            }
        });
    }
}
