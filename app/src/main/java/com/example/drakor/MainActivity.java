package com.example.drakor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.textview);
        textView.setSelected(true);
    }
    public void btn_create(View view){
        Intent a = new Intent(MainActivity.this, MainCreate.class);
        startActivity(a);
    }
    public void btn_read(View view) {
        Intent b = new Intent(MainActivity.this, MainRead.class);
        startActivity(b);
    }
}