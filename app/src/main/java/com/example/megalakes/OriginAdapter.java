package com.example.megalakes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import database.entities.Origin;

public class OriginAdapter extends ArrayAdapter<Origin> {
    private LayoutInflater inflater;
    private int layout;
    private List<Origin> origins;

    public OriginAdapter(Context context, int resource, List<Origin> origins) {
        super(context, resource, origins);
        this.origins = origins;
        layout = resource;
        inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);


        TextView idtext = view.findViewById(R.id.idtext);
        TextView origintext = view.findViewById(R.id.origintext);

        Origin origin = origins.get(position);

        idtext.setText(Long.toString(origin.id));
        origintext.setText(origin.origin);

        return view;
    }

    public Origin getOriginAt(int i)
    {
        return origins.get(i);
    }

}