package com.example.drakor;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private DatabaseDrakor db;
    private EditText Enama, Ejenis, Eeps;
    private String Snama, Sjenis, Seps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new DatabaseDrakor(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Eeps = (EditText) findViewById(R.id.create_eps);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Seps = String.valueOf(Eeps.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(com.example.drakor.MainCreate.this, "Silahkan isi nama drakor",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(com.example.drakor.MainCreate.this, "Silahkan isi jenis drakor",
                            Toast.LENGTH_SHORT).show();
                } else if (Seps.equals("")){
                    Eeps.requestFocus();
                    Toast.makeText(com.example.drakor.MainCreate.this, "Silahkan isi manfaat",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ejenis.setText("");
                    Eeps.setText("");
                    Toast.makeText(com.example.drakor.MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateDrakor(new Drakor(null, Snama, Sjenis, Seps));
                    Intent a = new Intent(com.example.drakor.MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
