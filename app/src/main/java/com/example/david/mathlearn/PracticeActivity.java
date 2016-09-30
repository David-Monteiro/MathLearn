package com.example.david.mathlearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PracticeActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup);

        Button b1 = (Button) findViewById(R.id.button_addition);
        Button b2 = (Button) findViewById(R.id.button_subtraction);
        Button b3 = (Button) findViewById(R.id.button_multiplication);
        Button b4 = (Button) findViewById(R.id.button_division);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        Intent intent = new Intent(PracticeActivity.this, Game.class);
        if(v.getId()== R.id.button_addition){
            intent.putExtra("Operator", "1");
            startActivity(intent);
        }
        else if(v.getId()== R.id.button_subtraction){
            intent.putExtra("Operator", "2");
            startActivity(intent);
        }
        else if(v.getId()== R.id.button_multiplication){
            intent.putExtra("Operator", "3");
            startActivity(intent);
        }
        else{
            intent.putExtra("Operator", "4");
            startActivity(intent);

        }


    }
}
