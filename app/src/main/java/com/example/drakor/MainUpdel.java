package com.example.drakor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private DatabaseDrakor db;
    private String Sid, Snama, Sjenis, Seps;
    private EditText Enama, Ejenis, Eeps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new DatabaseDrakor(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sjenis = i.getStringExtra("Ijenis");
        Seps = i.getStringExtra("Ieps");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Eeps = (EditText) findViewById(R.id.updel_eps);
        Enama.setText(Snama);
        Ejenis.setText(Sjenis);
        Eeps.setText(Seps);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Seps = String.valueOf(Eeps.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(com.example.drakor.MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(com.example.drakor.MainUpdel.this, "Silahkan isi jenis drakor",
                            Toast.LENGTH_SHORT).show();
                } else if (Seps.equals("")){
                    Eeps.requestFocus();
                    Toast.makeText(com.example.drakor.MainUpdel.this, "Silahkan isi eps drakor",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateDrakor(new Drakor(Sid, Snama, Sjenis, Seps));
                    Toast.makeText(com.example.drakor.MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteDrakor(new Drakor(Sid, Snama, Sjenis, Seps));
                Toast.makeText(com.example.drakor.MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}