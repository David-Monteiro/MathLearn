package com.example.david.mathlearn;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class GameEngine implements View.OnClickListener {

    ImageView num0;
    ImageView num1;
    ImageView operator;

    EditText input;
    Button b;
    int ans;

    Toast toast;
    int [] quest;

    Context ctx;

    public GameEngine(Context ctx0,ImageView n0,ImageView n1, ImageView op0, EditText in0, Button b0) {
        super();
        ctx = ctx0;
        num0 = n0;
        num1 = n1;
        operator = op0;
        input = in0;
        b = b0;
        quest = new int[4];
    }

    public void run() {


        ans = -1;
        questionGen();

        //generate a question and then display it

        numDisplay(num0, quest[0]);
        operatorDisplay(operator, quest[2]);
        numDisplay(num1, quest[1]);

        //wait for the answer
        b.setOnClickListener(this);

       // if(ans != quest[3]){
            //add to stats (dataFile.xml) 1 more wrong answer
        //}else {
            //add to stats (dataFile.xml) 1 more correct answer
            //add 1 more to correct answer streak
            // maybe create a class or a just a method to solve issue
            //if answer streak is equal to 10 reset to zero and add a star
            //after a star is added if it is divisable by 10 add a sticker
        //}
    }
    public void operatorDisplay(ImageView operator, int n){

        if(n == 1) 	operator.setImageResource(R.drawable.addition);
        else if(n == 2)	 operator.setImageResource(R.drawable.subtraction);
        else if(n == 3)	operator.setImageResource(R.drawable.multiplication);
        else 	operator.setImageResource(R.drawable.division);
        //here we simply make sure the correct operator is being displayed
    }

    public void setOperator(int n){
        quest[2] = n;
        //if necessary the operator can be changed directly using this functiom
        //it is used by class Game when the received intent is zero
    }
    public  void questionGen(){


        quest[0] = (int)(Math.random()*(10));
        quest[1] = (int)(Math.random()*(10));

        if (quest[2]<=0 || quest[2]>0){
            //if not null, do nothing
        }else {quest[2] = ((int) (Math.random() * (4))) + 1;}


        if(quest[2] == 1) 	quest[3] = quest[0] + quest[1];
        else if(quest[2] == 2)	 quest[3] = quest[0] - quest[1];
        else if(quest[2] == 3)	 quest[3] = quest[0] * quest[1];
        else 	quest[3] = quest[0] / quest[1];
        //Here we generate the questions
        //and the solution for the generated question
    }

    public void numDisplay(ImageView nV, int n0){
        if(n0 == 1){
            nV.setImageResource(R.drawable.one);
        }  else if(n0 == 2){
            nV.setImageResource(R.drawable.two);
        }  else if(n0 == 3){
            nV.setImageResource(R.drawable.three);
        }  else if(n0 == 4){
            nV.setImageResource(R.drawable.four);
        }  else if(n0 == 5){
            nV.setImageResource(R.drawable.five);
        }  else if(n0 == 6){
            nV.setImageResource(R.drawable.six);
        }  else if(n0 == 7){
            nV.setImageResource(R.drawable.seven);
        }  else if(n0 == 8){
            nV.setImageResource(R.drawable.eight);
        }  else if(n0 == 9){
            nV.setImageResource(R.drawable.nine);
        }  else {
            nV.setImageResource(R.drawable.zero);
        }

        //In this function we receive a number and make sure the
        //number is correctly displayed in the correct Imageview

    }

    public void onClick(View v){
        String temp = input.getText().toString();
        while(temp.equals("")){
            b.setOnClickListener(this);
        }
        ans = Integer.parseInt(temp);

        toast = Toast.makeText(ctx, "Correct!", Toast.LENGTH_LONG);

        if(ans != quest[3]){
            toast = Toast.makeText(ctx, "Wrong Answer!", Toast.LENGTH_LONG);
            toast.show();
            System.out.print("\n Wrong Answer!" );
        }else{
            toast.show();
            System.out.print("\n Correct!");
        }

        //In this method the user will keep trying to read the an input while the is not null.
        //After receiving the answeer the function will display a short message to the user
    }

    public void setLevel(int level){
        quest[2] = ((int) (Math.random() * (level/2))) + 1;
        if(quest[2] == 0){ quest[2] = 1;}
        else if(quest[2] >8){ quest[2] =8;}
        //this function will set the operator based on a a number
        //ranged between 1 and 10
    }
}
