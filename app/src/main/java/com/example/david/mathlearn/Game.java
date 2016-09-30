package com.example.david.mathlearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.*;


public class Game extends Activity {

   //ImageViews bellow will display the question so the user can answers
    ImageView num0;
    ImageView num1;
    ImageView operator;

    //editText and button will allow the user to answer the questions
    EditText ans1;
    Button b;

    //quest is an array that will store the question values, the operator and th solution
    //ans is where the user answer will be stores so it can be compared withthe actual solution
    //the toast is to display a note of whether the question is correct or incorrect
    int ans;
    Toast toast;
    int [] quest;

    int ope;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        num0 = (ImageView) findViewById(R.id.numberView0);
        num1 = (ImageView) findViewById(R.id.numberView1);
        operator = (ImageView) findViewById(R.id.operatorView0);

        ans1 = (EditText) findViewById(R.id.answerPanel);
        b = (Button) findViewById(R.id.button_Ans);

        //here we read an intent sent from the parent class
        ope = Integer.parseInt(getIntent().getStringExtra("Operator"));

        //we create and initiate the game engine
        //then we set the operator
        GameEngine gameEngine = new GameEngine(Game.this,num0, num1, operator, ans1, b);
       // for (int i = 0; i <10; i++){
            if (ope == 0) {
                gameEngine.setLevel(Integer.parseInt(getResources().getString(R.string.stickers)));
            } else {
                gameEngine.setOperator(ope);
            }
            gameEngine.run();
            while(ans == -1){}
            //System.out.println(i);
        //}
        ImageButton gameReturn = (ImageButton)findViewById(R.id.gameReturn);
        gameReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game.this, MenuActivity.class));
            }
        });
        ImageButton gameSkip = (ImageButton)findViewById(R.id.gameSkip);
        gameSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameEngine gameEngine0= new GameEngine(Game.this,num0, num1, operator, ans1, b);
                if(ope==0){
                    gameEngine0.setLevel(Integer.parseInt(getResources().getString(R.string.stickers)));
                }else{gameEngine0.setOperator(ope);}
                gameEngine0.run();
            }
        });

        //if intent sent is zero store data in
        //
    }
}