package com.example.david.mathlearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //test multiple buttons
        Button b1 = (Button) findViewById(R.id.button_challenges);
        Button b2 = (Button) findViewById(R.id.button_rewards);
        Button b3 = (Button) findViewById(R.id.button_practice);
        Button b4 = (Button) findViewById(R.id.button_about);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v.getId()== R.id.button_challenges){
            Intent intent = new Intent(new Intent(MenuActivity.this, Game.class));
            intent.putExtra("Operator", "0");
            startActivity(intent);
        }
        else if(v.getId()== R.id.button_rewards){
            startActivity(new Intent(MenuActivity.this, RewardsActivity.class));
        }
        else if(v.getId()== R.id.button_practice){
            startActivity(new Intent(MenuActivity.this, PracticeActivity.class));
        }
        else{
            startActivity(new Intent(MenuActivity.this, AboutActivity.class));

        }

    }
}
