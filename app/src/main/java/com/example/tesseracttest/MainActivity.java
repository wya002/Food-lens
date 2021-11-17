package com.example.tesseracttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView main_add;
    private Button main_next;
    private ImageView food_pork, food_chicken, food_beef, food_fish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_add = findViewById(R.id.main_add);
        main_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddListActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        main_next = findViewById(R.id.main_next);
        main_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        food_pork = findViewById(R.id.food_pork);
        food_beef = findViewById(R.id.food_beef);
        food_chicken = findViewById(R.id.food_chicken);
        food_fish = findViewById(R.id.food_fish);

        food_pork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = "돼지고기";
                if(MyApplication.data.contains(newItem)){
                    Toast toast = Toast.makeText(getApplicationContext(), "이미 추가된 항목입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    MyApplication.data.add(newItem);
                    Toast toast = Toast.makeText(getApplicationContext(),newItem+"를 추가했습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        food_beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = "소고기";
                if(MyApplication.data.contains(newItem)){
                    Toast toast = Toast.makeText(getApplicationContext(), "이미 추가된 항목입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    MyApplication.data.add(newItem);
                    Toast toast = Toast.makeText(getApplicationContext(),newItem+"를 추가했습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        food_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = "닭고기";
                if(MyApplication.data.contains(newItem)){
                    Toast toast = Toast.makeText(getApplicationContext(), "이미 추가된 항목입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    MyApplication.data.add(newItem);
                    Toast toast = Toast.makeText(getApplicationContext(),newItem+"를 추가했습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        food_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = "고등어";
                if(MyApplication.data.contains(newItem)){
                    Toast toast = Toast.makeText(getApplicationContext(), "이미 추가된 항목입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    MyApplication.data.add(newItem);
                    Toast toast = Toast.makeText(getApplicationContext(),newItem+"를 추가했습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}