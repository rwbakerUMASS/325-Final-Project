package com.team17.ilost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView options;
    ImageView account;
    ImageView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCustomActionBar();

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
    }
}