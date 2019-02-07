package com.example.akshay.getdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText fname,lname,email,pincode;
    Button submit,cancel;
    String FirstN,LastN,Email;
    int Pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendAllData();

    }

    private void sendAllData() {
        fname = findViewById(R.id.fname_id);
        lname = findViewById(R.id.lname_id);
        email = findViewById(R.id.email_id);
        pincode = findViewById(R.id.pin_id);
        submit = findViewById(R.id.submit_button);
        cancel = findViewById(R.id.cancel_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstN = fname.getText().toString();
                LastN = lname.getText().toString();
                Email = email.getText().toString();
                Pin = Integer.parseInt(pincode.getText().toString());

                Intent i = new Intent(MainActivity.this,DisplayData.class);
                i.putExtra("EXTRA_FNAME",FirstN);
                i.putExtra("EXTRA_LNAME",LastN);
                i.putExtra("EXTRA_EMAIL",Email);
                i.putExtra("EXTRA_PIN",Pin);
                startActivity(i);
            }
        });


    }
}
