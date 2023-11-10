package com.example.megalakes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.megalakes.fragments.OriginFragment;

import java.util.ArrayList;
import java.util.List;

import database.Database;
import database.entities.Origin;
import viewmodels.OriginViewModel;

public class OriginsActivity extends AppCompatActivity {

    OriginViewModel originViewModel;
    public Button addButton;
    public Button changeButton;
    public Button deleteButton;
    public Button backButton;

    public Origin selectedOrigin;

    public GridView grid;

    public ArrayList<Origin> orig = new ArrayList<Origin>();
    public Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origins);
        db = Database.getDatabase(this);
        addButton = findViewById(R.id.addButton);
        changeButton = findViewById(R.id.changeButton);
        deleteButton = findViewById(R.id.deleteButton);
        backButton = findViewById(R.id.backButton);
        grid = findViewById(R.id.grid);
        originViewModel = new ViewModelProvider(this).get(OriginViewModel.class);

        backButton.setOnClickListener((click) ->
        {
            Intent intent = new Intent(this, AllTablesActivity.class);
            startActivity(intent);
        });

        addButton.setOnClickListener((click) ->
        {
            getSupportFragmentManager().beginTransaction().add(R.id.consL, new OriginFragment(), "fr").addToBackStack("frg").commit();
        });

        changeButton.setOnClickListener((click) ->
        {
            if (selectedOrigin != null) {
                getSupportFragmentManager().beginTransaction().add(R.id.consL, new OriginFragment(selectedOrigin.id), "fr").addToBackStack("frg").commit();
            }
        });

        deleteButton.setOnClickListener((click) ->
        {
            if (selectedOrigin != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Удаление");
                builder.setMessage("Удалить?");
                builder.setCancelable(true);
                builder.setPositiveButton("Да", (dialogInterface, i1) -> originViewModel.delete(selectedOrigin));
                builder.setNegativeButton("Нет", (dialogInterface, i2) -> dialogInterface.dismiss());
                builder.show();
            }
        });

        originViewModel.getAllData().observe(this, new Observer<List<Origin>>() {
            @Override
            public void onChanged(List<Origin> origins) {
                grid.setAdapter(new OriginAdapter(getApplicationContext(), R.layout.originlayout, origins));
            }
        });


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedOrigin = ((OriginAdapter)parent.getAdapter()).getOriginAt(position);
            }
        });
    }
}