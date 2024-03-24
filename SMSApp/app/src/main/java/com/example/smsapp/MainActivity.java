package com.example.smsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNo , message;

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /*
        // Important: dont forget to add permission in AndroidManifests.xml
        */

        // Not Required
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind elements
        send = findViewById(R.id.send);
        phoneNo = findViewById(R.id.phoneNo);
        message = findViewById(R.id.message);

        // Create an event Listener
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    private void sendSMS(){
        // Extract data
        String text = message.getText().toString();
        String number = phoneNo.getText().toString();

        // test for NULL values
        if(number == ""){
            Toast.makeText(this,"Enter Phone Number",Toast.LENGTH_LONG).show();
        } else if (text == "") {
            Toast.makeText(this , "Enter Message" , Toast.LENGTH_LONG).show();
        }else{
            // create an intent
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            // set destination number
            intent.setData(Uri.parse("smsto:" + number));
            // set Message body
            intent.putExtra("sms_body",text);

            // start Intent
            try{
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this , "Error while sending message", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }

    }
}