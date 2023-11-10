package com.example.megalakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import database.Database;
import database.entities.Origin;

public class LakesActivity extends AppCompatActivity {

    public Button addButton;
    public Button changeButton;
    public Button deleteButton;
    public Button backButton;

    public GridView grid;

    public ArrayList<Origin> orig = new ArrayList<Origin>();
    public Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lakes);
        db = Database.getDatabase(this);
        addButton = findViewById(R.id.addButton);
        changeButton = findViewById(R.id.changeButton);
        deleteButton = findViewById(R.id.deleteButton);
        backButton = findViewById(R.id.backButton);
        grid = findViewById(R.id.grid);

        backButton.setOnClickListener((click) ->
        {
            Intent intent = new Intent(this, AllTablesActivity.class);
            startActivity(intent);
        });

        UpdateOrigins();

        OriginAdapter originAdapter = new OriginAdapter(this, R.layout.originlayout, orig);

        grid.setAdapter(originAdapter);
    }

    public void UpdateOrigins()
    {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                orig.clear();
                orig.addAll(db.originDao().getAllOrigins());
            }
        });
        t1.start();
    }
}