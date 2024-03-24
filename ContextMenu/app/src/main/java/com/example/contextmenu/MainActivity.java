package com.example.contextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;

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

        // Bind layout
        layout = findViewById(R.id.relLayout);
        // Register for Context Menu
        registerForContextMenu(layout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu , View v , ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);

        // add data
        menu.add(0,v.getId(),0,"Yellow");
        menu.add(0,v.getId(),0,"Red");
        menu.add(0,v.getId(),0,"Blue");
        menu.add(0,v.getId(),0,"Green");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        // get Color as string
        String color = item.getTitle().toString();

        // change color
        switch (color){
            case "Yellow" :
                layout.setBackgroundColor(Color.YELLOW);
                break;

            case "Red" :
                layout.setBackgroundColor(Color.RED);
                break;

            case "Blue" :
                layout.setBackgroundColor(Color.BLUE);
                break;

            case "Green" :
                layout.setBackgroundColor(Color.GREEN);
                break;

            default:
                layout.setBackgroundColor(Color.WHITE);
                break;
        }
        return true;
    }


}