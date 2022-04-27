package com.team17.ilost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ImageView options;
    ImageView account;
    ImageView search;
    Button lost;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;

    TextView title1;
    TextView title2;
    TextView title3;
    TextView title4;
    TextView title5;

    FloatingActionButton newPosting;

    GridLayout grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCustomActionBar();

        grid=findViewById(R.id.grid);

        title1=findViewById(R.id.title1);
        title2=findViewById(R.id.title2);
        title3=findViewById(R.id.title3);
        title4=findViewById(R.id.title4);
        title5=findViewById(R.id.title5);

        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);

        defaultHome();

        lost=findViewById(R.id.lost_button);
        lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LostItems.class));
            }
        });

        newPosting=findViewById(R.id.newPosting);
        newPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    protected void defaultHome(){
        image1.setImageResource(R.drawable.airpods);
        image2.setImageResource(R.drawable.keys);
        image3.setImageResource(R.drawable.wallet);
        image4.setImageResource(R.drawable.laptop1);
        image5.setImageResource(R.drawable.laptop2);
        title1.setText("Airpod Pros");
        title2.setText("Keys");
        title3.setText("Wallet");
        title4.setText("Lenovo Laptop");
        title5.setText("Dell Laptop");
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PostingPage.class));
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
                PopupMenu popup = new PopupMenu(MainActivity.this, view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.options_menu, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.clear:
                                defaultHome();
                                return true;
                            case R.id.time:
                                Toast.makeText(MainActivity.this,"Sorting by: Time", Toast.LENGTH_SHORT).show();
                                image3.setImageResource(R.drawable.airpods);
                                image5.setImageResource(R.drawable.keys);
                                image1.setImageResource(R.drawable.wallet);
                                image4.setImageResource(R.drawable.laptop1);
                                image2.setImageResource(R.drawable.laptop2);
                                title3.setText("Airpod Pros");
                                title5.setText("Keys");
                                title1.setText("Wallet");
                                title4.setText("Lenovo Laptop");
                                title2.setText("Dell Laptop");
                                return true;
                            case R.id.location:
                                Toast.makeText(MainActivity.this,"Sorting by: Proximity to you", Toast.LENGTH_SHORT).show();
                                image4.setImageResource(R.drawable.airpods);
                                image1.setImageResource(R.drawable.keys);
                                image2.setImageResource(R.drawable.wallet);
                                image5.setImageResource(R.drawable.laptop1);
                                image3.setImageResource(R.drawable.laptop2);
                                title4.setText("Airpod Pros");
                                title1.setText("Keys");
                                title3.setText("Wallet");
                                title5.setText("Lenovo Laptop");
                                title3.setText("Dell Laptop");
                                return true;
                            case R.id.keys:
                                Toast.makeText(MainActivity.this,"Showing: Keys", Toast.LENGTH_SHORT).show();
                                image1.setImageResource(R.drawable.keys);
                                image2.setImageResource(0);
                                image3.setImageResource(0);
                                image4.setImageResource(0);
                                image5.setImageResource(0);
                                title1.setText("Keys");
                                title2.setText("");
                                title3.setText("");
                                title4.setText("");
                                title5.setText("");
                                return true;
                            case R.id.books:
                                Toast.makeText(MainActivity.this,"Showing: Books", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.laptop:
                                Toast.makeText(MainActivity.this,"Showing: Laptops", Toast.LENGTH_SHORT).show();
                                image1.setImageResource(R.drawable.laptop1);
                                image2.setImageResource(R.drawable.laptop2);
                                image3.setImageResource(0);
                                image4.setImageResource(0);
                                image5.setImageResource(0);
                                title1.setText("Lenovo Laptop");
                                title2.setText("Dell Laptop");
                                title3.setText("");
                                title4.setText("");
                                title5.setText("");
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
            }
        });
    }
}