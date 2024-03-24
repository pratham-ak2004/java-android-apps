package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button add , sub , mul , div , clear;
    private EditText inputOne , inputTwo;
    private TextView result;


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
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        clear = findViewById(R.id.clear);

        inputOne = findViewById(R.id.inputOne);
        inputTwo = findViewById(R.id.inputTwo);

        result = findViewById(R.id.result);


        // add Event Listener for each button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate(1);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate(2);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate(3);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operate(4);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOne.setText("");
                inputTwo.setText("");
                result.setText("");
            }
        });


    }

    // global function to execute mathematical operations
    private void operate(int i){
        // extract value as string and convert into Integer;
        int first = Integer.parseInt(inputOne.getText().toString());
        int second = Integer.parseInt(inputTwo.getText().toString());

        StringBuilder builder = new StringBuilder();

        switch (i){
            case 1:
                builder.append(first+second);
                result.setText(builder.toString());
                break;

            case 2:
                builder.append(first-second);
                result.setText(builder.toString());
                break;

            case 3:
                builder.append(first*second);
                result.setText(builder.toString());
                break;

            case 4:
                builder.append(first/second);
                result.setText(builder.toString());
                break;

            default:
                result.setText("Invalid");
                break;
        }
    }



}