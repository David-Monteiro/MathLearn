package com.example.david.mathlearn;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;


public class AboutActivity extends ListActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        ImageButton bt = (ImageButton) findViewById(R.id.aboutReturn);
        bt.setOnClickListener(this);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.playerData)));


    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(AboutActivity.this, MenuActivity.class));
    }
}
