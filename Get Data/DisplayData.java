package com.example.akshay.getdata;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity
{
    TextView fname,lname,email,pincode;
    Button cancel;
    String FirstN,LastN,Email;
    int Pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        getAllData();
    }

    private void getAllData() {
        fname = findViewById(R.id.fname_text);
        lname = findViewById(R.id.lname_text);
        email = findViewById(R.id.email_text);
        pincode = findViewById(R.id.pincode_text);
        cancel = findViewById(R.id.quit_button);

        Intent i = getIntent();
        FirstN = i.getStringExtra("EXTRA_FNAME");
        LastN = i.getStringExtra("EXTRA_LNAME");
        Email = i.getStringExtra("EXTRA_EMAIL");
        Pin = i.getIntExtra("EXTRA_PIN",0);

        fname.setText(FirstN);
        lname.setText(LastN);
        email.setText(Email);
        pincode.setText(Pin+"");

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bldr = new AlertDialog.Builder(DisplayData.this);
                bldr.setTitle("Quit");
                bldr.setMessage("Is this Correct Information?");
                bldr.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DisplayData.super.finish();
                    }
                });
                bldr.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(DisplayData.this,MainActivity.class);
                        startActivity(i);
                    }
                });
                bldr.show();
            }
        });



    }
}
