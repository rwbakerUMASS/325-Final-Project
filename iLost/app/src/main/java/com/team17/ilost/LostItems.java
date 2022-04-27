package com.team17.ilost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class LostItems extends AppCompatActivity {

    ImageView options;
    ImageView account;
    ImageView search;
    Button found;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_items);

        createCustomActionBar();
        found=findViewById(R.id.found_button);
        found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LostItems.this, MainActivity.class));
            }
        });


    }
    protected void createCustomActionBar(){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);

        options = findViewById(R.id.options);
        options.setImageResource(R.drawable.menu);
        account = findViewById(R.id.account);
        account.setImageResource(R.drawable.account);
        search = findViewById(R.id.search);
        search.setImageResource(R.drawable.search);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(LostItems.this, view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.options_menu, popup.getMenu());
                popup.show();
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LostItems.this, "Account", Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LostItems.this, "Search", Toast.LENGTH_SHORT).show();
            }
        });
    }
}