package com.example.tesseracttest;

import android.bluetooth.le.ScanCallback;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AddListActivity extends AppCompatActivity {

    private ListView list;
    private EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        list = (ListView)findViewById(R.id.list);

        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);

        txtInput = (EditText) findViewById(R.id.add_list_text);

        Button btn_add_list = (Button) findViewById(R.id.add_list_btn);
        btn_add_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = txtInput.getText().toString();
                data.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });

        // 스캔하러 가기
        Button btn_add_list_scan = (Button) findViewById(R.id.add_list_scan);
        btn_add_list_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddListActivity.this, ScanActivity.class);
                AddListActivity.this.startActivity(intent);
            }
        });
    }
}