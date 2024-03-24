package com.example.optionsmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // change setContent to second_activity (Required)
        setContentView(R.layout.second_activity);
        EdgeToEdge.enable(this);

        previous = findViewById(R.id.previous);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

    }

    private void openActivity1(){
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

}
