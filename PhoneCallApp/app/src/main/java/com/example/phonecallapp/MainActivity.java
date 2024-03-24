package com.example.phonecallapp;

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

    private Button call;
    private EditText phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Not Required
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Binding elements
        call = findViewById(R.id.call);
        phoneNo = findViewById(R.id.phoneNo);

        /*
        // DON'T FORGET TO ADD PERMISSION IN AndroidManifest.xml
         */
        // Add Event Listener
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhoneNo();
            }
        });

    }

    // Function to call
    private void callPhoneNo() {
        // get phone no
        String number = phoneNo.getText().toString();

        // checking if phone no is not null
        // number.equals("") is same as number == ""
        if(number.equals("")){
            Toast.makeText(this, "Enter valid phone number",Toast.LENGTH_LONG).show();
            return;
        }

        // create new dial intent
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+number));

        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this,"Error occured while dialing" , Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}