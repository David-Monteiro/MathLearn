package com.example.david.mathlearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;


public class RewardsActivity extends Activity {
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        ImageButton returnB = (ImageButton)findViewById(R.id.rewardsReturn);
        returnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RewardsActivity.this, MenuActivity.class));
            }
        });

        int stickers = Integer.parseInt(getResources().getString(R.string.stickers));
        int stars = (Integer.parseInt(getResources().getString(R.string.stars)));

        Integer [] sBook = new Integer[100];

        Integer goldS = R.drawable.golden_star;
        Integer blankS = R.drawable.blank_star;

        for(int x=0; x < 100; x++){
            if(x < stars) {
                sBook[x] = goldS;
            }
            else {
                sBook[x] = blankS;
            }
        }

        gv = (GridView)findViewById(R.id.gridView);
        gv.setAdapter(new CustomGridAdapter(RewardsActivity.this, sBook));
    }
}
