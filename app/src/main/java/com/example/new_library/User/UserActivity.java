package com.example.new_library.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;
import com.example.new_library.admin.DBHandler;

public class UserActivity extends AppCompatActivity {

    Button loginUser;
    DBHandler dbHandler;

    EditText cardNo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        dbHandler = new DBHandler(this);

        cardNo = findViewById(R.id.login_cno);
        loginUser = findViewById(R.id.login);

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cno = loginUser.getText().toString();

                // Assuming you have a method in DBHandler for login that returns a boolean
                // In UserActivity.java
                boolean loginSuccessful = dbHandler.LoginUser(cno);

                if (loginSuccessful) {
                    Toast.makeText(UserActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // If login is successful, create an Intent to start another activity
                    Intent intent = new Intent(UserActivity.this, UserHomeActivity.class);
                    startActivity(intent);
                } else {
                    // Handle failed login
                    Toast.makeText(UserActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
