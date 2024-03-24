package com.example.foodmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox one , two , three , four;

    private Button submit;

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

        // items binding
        one = findViewById(R.id.checkBox1);
        two = findViewById(R.id.checkBox2);
        three = findViewById(R.id.checkBox3);
        four = findViewById(R.id.checkBox4);
        submit = findViewById(R.id.submit);

        // Adding eventListener
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom function to show toast
                showToastOnSubmit();
            }
        });
    }

    private void showToastOnSubmit(){
        StringBuilder builder = new StringBuilder();

        // Extracting values from checked boxes
        if(one.isChecked()){
            builder.append(one.getText().toString()).append(" ");
        }
        if(two.isChecked()){
            builder.append(two.getText().toString()).append(" ");
        }
        if(three.isChecked()){
            builder.append(three.getText().toString()).append(" ");
        }
        if(four.isChecked()){
            builder.append(four.getText().toString()).append(" ");
        }

        if(!builder.toString().equals("")){
            Toast.makeText(this,"Items selected "+builder.toString(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"No items selected" , Toast.LENGTH_LONG).show();
        }
    }

}