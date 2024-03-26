package com.example.randomcolor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button change;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Not required
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind elements
        change = findViewById(R.id.button);
        view = findViewById(R.id.colorView);

        // Add event Listener
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColor();
            }
        });

    }

    private void changeColor(){
        // Initialize object of random
        Random rd = new Random();

        // get random values for red , green and blue withing 255 (because color ranges from 0 to 255 only)
        int r = rd.nextInt(255);
        int g = rd.nextInt(225);
        int b = rd.nextInt(225);

        // set background color
        view.setBackgroundColor(Color.rgb(r,g,b));
    }


}