package com.example.megalakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AllTablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tables);

        Button b = findViewById(R.id.originButton);

        b.setOnClickListener((click) ->
        {
            Intent intent = new Intent(this, OriginsActivity.class);
            startActivity(intent);
        });
    }
}