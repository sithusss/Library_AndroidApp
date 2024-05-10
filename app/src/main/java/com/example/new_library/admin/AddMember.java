package com.example.new_library.admin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;

public class AddMember extends AppCompatActivity {

    Button addMember;
    DBHandler dbHandler;

    EditText cardNoEditText, nameEditText, addressEditText, phoneEditText, duesEditText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);


        dbHandler = new DBHandler(this);

        cardNoEditText = findViewById(R.id.card_no);
        nameEditText = findViewById(R.id.mem_name);
        addressEditText = findViewById(R.id.mem_addr);
        phoneEditText = findViewById(R.id.mem_phone);
        duesEditText = findViewById(R.id.unpaid_dues);

        addMember = findViewById(R.id.member);

        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardNo = cardNoEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                double dues = Double.parseDouble(duesEditText.getText().toString());
                // Start AdminActivity
                dbHandler.addNewMember(cardNo,name,address,phone,dues);
            }
        });
    }
}
