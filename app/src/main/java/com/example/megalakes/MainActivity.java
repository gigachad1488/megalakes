package com.example.megalakes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import database.Database;
import database.entities.Origin;

public class MainActivity extends AppCompatActivity {

    public Button ob;
    public EditText oet;
    public TextView ot;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Database.getDatabase(this);
        ob = findViewById(R.id.updateOriginButton);
        oet = findViewById(R.id.editTextOrigin);
        ot = findViewById(R.id.originsText);

        ob.setOnClickListener((click) ->
        {
            Runnable io = () -> {
                Origin or = new Origin();
                or.origin = oet.getText().toString();
                db.originDao().insert(or);

                List<Origin> origins = db.originDao().getAllOrigins();
                String s = "";
                for (int i = 0; i < origins.size(); i++)
                {
                    s += origins.get(i).origin + "    ";
                }
                ot.setText(s);
            };
            io.run();
        });



    }
}