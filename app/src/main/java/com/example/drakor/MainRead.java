package com.example.drakor;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseDrakor db;
    private List<Drakor> ListDrakor = new ArrayList<Drakor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new DatabaseDrakor(this);
        adapter_off = new CustomListAdapter(this, ListDrakor );
        mListView = (ListView) findViewById(R.id.list_drakor);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListDrakor.clear();
        List<Drakor> contacts = db.ReadDrakor();
        for (Drakor cn : contacts) {
            Drakor dataDrakor = new Drakor();
            dataDrakor.setmId(cn.getmId());
            dataDrakor.setmNama(cn.getmNama());
            dataDrakor.setmJenis(cn.getmJenis());
            dataDrakor.setmEpisode(cn.getmEpisode());
            ListDrakor.add(dataDrakor);
            if ((ListDrakor.isEmpty()))
                Toast.makeText(com.example.drakor.MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Drakor obj_itemDetails = (Drakor)o;
        String Sid = obj_itemDetails.getmId();
        String Snama = obj_itemDetails.getmNama();
        String Sjenis = obj_itemDetails.getmJenis();
        String Seps = obj_itemDetails.getmEpisode();
        Intent goUpdel = new Intent(com.example.drakor.MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Iepisode", Seps);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListDrakor.clear();
        mListView.setAdapter(adapter_off);
        List<Drakor> contacts = db.ReadDrakor();
        for (Drakor cn : contacts) {
            Drakor dataDrakor = new Drakor();
            dataDrakor.setmId(cn.getmId());
            dataDrakor.setmNama(cn.getmNama());
            dataDrakor.setmJenis(cn.getmJenis());
            dataDrakor.setmEpisode(cn.getmEpisode());
            ListDrakor.add(dataDrakor);
            if ((ListDrakor.isEmpty()))
                Toast.makeText(com.example.drakor.MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
