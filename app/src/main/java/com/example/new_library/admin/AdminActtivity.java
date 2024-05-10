package com.example.new_library.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.new_library.R;

public class AdminActtivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin); // Set the layout XML file for AdminActivity

            Button btn_member = findViewById(R.id.btn_member);
            Button btn_author = findViewById(R.id.btn_author);
            Button btn_publisher = findViewById(R.id.btn_publisher);
            Button btn_branch = findViewById(R.id.btn_branch);
            Button btn_book = findViewById(R.id.btn_book);
            Button btn_copies = findViewById(R.id.btn_copy);

            btn_member.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start AdminActivity
                    Intent intent = new Intent(AdminActtivity.this, AddMember.class);
                    startActivity(intent);
                }


            });

            btn_author.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start AdminActivity
                    Intent intent = new Intent(AdminActtivity.this, AddAuthor.class);
                    startActivity(intent);
                }


            });

            btn_publisher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start AdminActivity
                    Intent intent = new Intent(AdminActtivity.this, AddPublisher.class);
                    startActivity(intent);
                }


            });
            btn_branch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start AdminActivity
                    Intent intent = new Intent(AdminActtivity.this, AddBranch.class);
                    startActivity(intent);
                }


            });
            btn_book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start AdminActivity
                    Intent intent = new Intent(AdminActtivity.this, AddBook.class);
                    startActivity(intent);
                }


            });
            btn_copies.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start AdminActivity
                    Intent intent = new Intent(AdminActtivity.this, AddCopies.class);
                    startActivity(intent);
                }


            });


        }
    }
